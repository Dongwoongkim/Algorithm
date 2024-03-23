import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static char[][] miro;
    static int[][] result;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new char[n + 1][m + 1];
        result = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                miro[i][j] = line.charAt(j);
            }
        }

        bfs(0, 0);
        System.out.println(result[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        result[x][y] = 1;
        check[x][y] = true;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            int curX = q.peek().x;
            int curY = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (check[nextX][nextY] == false && miro[nextX][nextY] == '1') {
                        check[nextX][nextY] = true;
                        result[nextX][nextY] = result[curX][curY] + 1;
                        q.add(new Pair(nextX, nextY));
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
