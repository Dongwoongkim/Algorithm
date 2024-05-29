import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도착지점에서 시작점으로 거꾸로 탐색
        System.out.println(dfs(n - 1, m - 1));
    }

    private static int dfs(int x, int y) {
        // 시작점 도착한 경우 +1 리턴
        if (x == 0 && y == 0) {
            return 1;
        }

        // 탐색 해본 적이 있는 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        // 현재 지점에서 (0, 0)으로 이동하는 경로를 메모리제이션
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                continue;
            }

            if (map[nextX][nextY] > map[x][y]) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }

        return dp[x][y];
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
