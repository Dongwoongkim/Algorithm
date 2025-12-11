import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] dp;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            dp = new int[n + 1][n + 1];
            map = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            dp[1][1] = map[1][1];
            sb.append(bfs(1, 1, t)).append("\n");
            t++;
        }
        System.out.print(sb);
    }

    private static String bfs(int x, int y, int t) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int curX = current.x;
            int curY = current.y;

            if (dp[curX][curY] != Integer.MAX_VALUE) {
                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                        int cost = dp[curX][curY] + map[nx][ny];
                        if (dp[nx][ny] > cost) {
                            dp[nx][ny] = cost;
                            queue.add(new Position(nx, ny));
                        }
                    }
                }
            }
        }

        return "Problem " + t + ": " + dp[n][n];
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
