import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int cnt0 = 0;
        check = new boolean[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (arr[j][k] == 'R' && check[j][k] == false) {
                    bfs(j, k, 'R');
                    cnt0++;
                }

                if (arr[j][k] == 'B' && check[j][k] == false) {
                    bfs(j, k, 'B');
                    cnt0++;
                }

                if (arr[j][k] == 'G' && check[j][k] == false) {
                    bfs(j, k, 'G');
                    cnt0++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        check = new boolean[n + 1][n + 1];
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (arr[j][k] == 'R' && check[j][k] == false) {
                    bfs(j, k, 'R');
                    cnt++;
                }

                if (arr[j][k] == 'B' && check[j][k] == false) {
                    bfs(j, k, 'B');
                    cnt++;
                }
            }
        }

        System.out.println(cnt0 + " " + cnt);
    }

    private static void bfs(int x, int y, char k) {
        Queue<Position> queue = new LinkedList<>();
        check[x][y] = true;
        queue.add(new Position(x, y));
        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    char v = arr[nextX][nextY];
                    if (v == k && check[nextX][nextY] == false) {
                        check[nextX][nextY] = true;
                        queue.add(new Position(nextX, nextY));
                    }
                }
            }
        }
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
