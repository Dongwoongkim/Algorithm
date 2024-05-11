import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int ans = 0;
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] check = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        check[map[x][y] - 65] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                if (visited[nextX][nextY] == false && check[map[nextX][nextY] - 65] == false) {
                    visited[nextX][nextY] = true;
                    check[map[nextX][nextY] - 65] = true;
                    dfs(nextX, nextY, cnt + 1);
                    visited[nextX][nextY] = false;
                    check[map[nextX][nextY] - 65] = false;
                }
            }
        }
        
        ans = Math.max(ans, cnt);
    }
}
