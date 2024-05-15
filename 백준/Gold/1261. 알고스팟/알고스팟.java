import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        check = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int x, int y) {
        PriorityQueue<CurrentState> q = new PriorityQueue<>();
        q.add(new CurrentState(x, y, 0));
        check[x][y] = 1;

        while (!q.isEmpty()) {
            CurrentState cur = q.poll();

            int curX = cur.x;
            int curY = cur.y;

            if (curX == n - 1 && curY == m - 1) {
                System.out.println(cur.broke);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
                    if (map[nX][nY] == 0 && check[nX][nY] == -1) {
                        check[nX][nY] = 1;
                        q.add(new CurrentState(nX, nY, cur.broke));
                    }

                    if (map[nX][nY] == 1 && check[nX][nY] == -1) {
                        check[nX][nY] = 1;
                        q.add(new CurrentState(nX, nY, cur.broke + 1));
                    }
                }
            }
        }
    }

    static class CurrentState implements Comparable<CurrentState> {
        int x;
        int y;
        int broke;

        public CurrentState(int x, int y, int broke) {
            this.x = x;
            this.y = y;
            this.broke = broke;
        }

        @Override
        public int compareTo(CurrentState o) {
            return Integer.compare(this.broke, o.broke);
        }
    }
}
