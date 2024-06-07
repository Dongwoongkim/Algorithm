import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    static int ans = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        int swordX = -1;
        int swordY = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    swordX = i;
                    swordY = j;
                }
            }
        }

        // 시작지점 -> 칼 -> 도착지점
        int result = bfs(0, 0, swordX, swordY, true);
        if (result != -1) {
            int result2 = bfs(swordX, swordY, n - 1, m - 1, false);
            if (result2 != -1 && result + result2 <= k) {
                ans = Math.min(ans, result2 + result);
            }
        }

        // 시작지점 -> 도착지점
        int result3 = bfs(0, 0, n - 1, m - 1, true);

        if (result3 != -1) {
            ans = Math.min(result3, ans);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }
    }

    private static int bfs(int x, int y, int goalX, int goalY, boolean flag) {
        boolean[][] check = new boolean[n + 1][m + 1];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y, 0));
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int curX = pos.x;
            int curY = pos.y;
            int curTime = pos.t;

            if (curX == goalX && curY == goalY) {
                return curTime;
            }

            if (curTime >= k) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (flag) {
                    if (!check[nx][ny] && map[nx][ny] != 1) {
                        check[nx][ny] = true;
                        queue.add(new Position(nx, ny, curTime + 1));
                    }
                } else {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        queue.add(new Position(nx, ny, curTime + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Position {
        int x;
        int y;
        int t;

        public Position(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
