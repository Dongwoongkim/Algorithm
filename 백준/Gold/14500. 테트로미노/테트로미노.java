import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int ans = -1;
    static int[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                check[i][j] = false;
            }
        }

        // ㅗ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1
                int x1 = i;
                int y1 = j;

                int x2 = i + 1;
                int y2 = j;

                int x3 = i + 1;
                int y3 = j - 1;

                int x4 = i + 1;
                int y4 = j + 1;

                if (x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 0
                        && x1 < n && x2 < n && x3 < n && x4 < n
                        && y1 >= 0 && y2 >= 0 && y3 >= 0 && y4 >= 0
                        && y1 < m && y2 < m && y3 < m && y4 < m) {
                    int sum = map[x1][y1] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    ans = Math.max(ans, sum);
                }
            }
        }

        // ㅓ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1
                int x1 = i;
                int y1 = j;

                int x2 = i;
                int y2 = j + 1;

                int x3 = i - 1;
                int y3 = j + 1;

                int x4 = i + 1;
                int y4 = j + 1;

                if (x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 0
                        && x1 < n && x2 < n && x3 < n && x4 < n
                        && y1 >= 0 && y2 >= 0 && y3 >= 0 && y4 >= 0
                        && y1 < m && y2 < m && y3 < m && y4 < m) {
                    int sum = map[x1][y1] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    ans = Math.max(ans, sum);
                }
            }
        }

        // ㅜ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1
                int x1 = i;
                int y1 = j;

                int x2 = i - 1;
                int y2 = j;

                int x3 = i - 1;
                int y3 = j - 1;

                int x4 = i - 1;
                int y4 = j + 1;

                if (x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 0
                        && x1 < n && x2 < n && x3 < n && x4 < n
                        && y1 >= 0 && y2 >= 0 && y3 >= 0 && y4 >= 0
                        && y1 < m && y2 < m && y3 < m && y4 < m) {
                    int sum = map[x1][y1] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    ans = Math.max(ans, sum);
                }
            }
        }

        // ㅏ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1
                int x1 = i;
                int y1 = j;

                int x2 = i;
                int y2 = j - 1;

                int x3 = i - 1;
                int y3 = j - 1;

                int x4 = i + 1;
                int y4 = j - 1;

                if (x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 0
                        && x1 < n && x2 < n && x3 < n && x4 < n
                        && y1 >= 0 && y2 >= 0 && y3 >= 0 && y4 >= 0
                        && y1 < m && y2 < m && y3 < m && y4 < m) {
                    int sum = map[x1][y1] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    ans = Math.max(ans, sum);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1
                int x1 = i;
                int y1 = j;

                int x2 = i + 1;
                int y2 = j;

                int x3 = i + 1;
                int y3 = j - 1;

                int x4 = i + 1;
                int y4 = j + 1;

                if (x1 >= 0 && x2 >= 0 && x3 >= 0 && x4 >= 0
                        && x1 < n && x2 < n && x3 < n && x4 < n
                        && y1 >= 0 && y2 >= 0 && y3 >= 0 && y4 >= 0
                        && y1 < m && y2 < m && y3 < m && y4 < m) {
                    int sum = map[x1][y1] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (check[nx][ny] == false) {
                check[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
                check[nx][ny] = false;
            }
        }
    }
}
