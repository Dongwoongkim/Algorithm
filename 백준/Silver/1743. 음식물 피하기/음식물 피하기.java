import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static boolean[][] trash = new boolean[101][101];
    static boolean[][] check = new boolean[101][101];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            trash[x][y] = true;
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (trash[i][j] && !check[i][j]) {
                    int size = dfs(i, j);
                    ans = Math.max(ans, size);
                }
            }
        }

        System.out.print(ans);
    }

    private static int dfs(int x, int y) {
        check[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                if (trash[nx][ny] && !check[nx][ny]) {
                    cnt += dfs(nx, ny);
                }
            }
        }

        return cnt;
    }
}
