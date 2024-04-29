import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    // 오른쪽 위, 오른쪽, 오른쪽 아래 순서
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static int ans = 0;
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }

        }

        for (int i = 0; i < n; i++) {
            check[i][0] = true;
            boolean result = dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static boolean dfs(int x, int y) {
        if (y == m - 1) {
            ans++;
            check[x][y] = true;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                if (map[nextX][nextY] == '.' && check[nextX][nextY] == false) {
                    check[nextX][nextY] = true;
                    boolean result = dfs(nextX, nextY);
                    if (result == false) {
                        continue;
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
