import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

        int year = 0;
        while (true) {
            int result = getResult();
            if (result >= 2) {
                System.out.println(year);
                break;
            }
            if (result == 0) {
                System.out.println(0);
                break;
            }

            simulation();
            year++;
        }

    }

    private static int getResult() {
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    if (!visited[i][j]) {
                        dfs(i, j, visited);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }

    private static void simulation() {
        int[][] tmpMap = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int zeroCnt = 0;
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m) {
                            if (map[x][y] == 0) {
                                zeroCnt++;
                            }
                        }
                    }
                }

                tmpMap[i][j] = Math.max(tmpMap[i][j] - zeroCnt, 0);
            }
        }

        map = tmpMap;
    }
}