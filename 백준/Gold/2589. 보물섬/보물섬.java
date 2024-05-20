import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ans = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map = new char[51][51];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();

        int max = -1;
        boolean[][] check = new boolean[n + 1][m + 1];
        int[][] depth = new int[n + 1][m + 1];

        check[x][y] = true;
        q.add(new Position(x, y, 0));

        while (!q.isEmpty()) {
            Position pos = q.poll();
            int curX = pos.x;
            int curY = pos.y;
            int curDepth = pos.depth;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 'L' && check[nx][ny] == false) {
                    check[nx][ny] = true;
                    depth[nx][ny] = curDepth + 1;
                    q.add(new Position(nx, ny, curDepth + 1));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, depth[i][j]);
            }
        }

        return max;
    }

    static class Position {
        int x;
        int y;
        int depth;

        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
