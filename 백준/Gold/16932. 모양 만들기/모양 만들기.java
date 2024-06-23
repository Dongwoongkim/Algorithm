import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
    static int[][] map;
    static int[][] answer;
    static int[][] groupNumber;
    static int order = 1;
    static int ans = -1;
    static Map<Integer, Integer> dict = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        answer = new int[n + 1][m + 1];
        groupNumber = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    check[i][j] = true;
                    bfs(i, j);
                    order++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                HashSet<Integer> groupNumSet = new HashSet<>();

                if (map[i][j] == 0) {
                    if (i - 1 >= 0 && map[i - 1][j] == 1) {
                        groupNumSet.add(groupNumber[i - 1][j]);
                    }

                    if (i + 1 < n && map[i + 1][j] == 1) {
                        groupNumSet.add(groupNumber[i + 1][j]);
                    }

                    if (j - 1 >= 0 && map[i][j - 1] == 1) {
                        groupNumSet.add(groupNumber[i][j - 1]);
                    }

                    if (j + 1 < m && map[i][j + 1] == 1) {
                        groupNumSet.add(groupNumber[i][j + 1]);
                    }
                }

                for (Integer groupNumber : groupNumSet) {
                    answer[i][j] += dict.get(groupNumber);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(answer[i][j] + 1, ans);
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        check[x][y] = true;
        groupNumber[x][y] = order;

        int cnt = 1;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (!check[nx][ny] && map[nx][ny] == 1) {
                    groupNumber[nx][ny] = order;
                    check[nx][ny] = true;
                    cnt++;
                    queue.add(new Position(nx, ny));
                }
            }
        }

        dict.put(order, cnt);
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
