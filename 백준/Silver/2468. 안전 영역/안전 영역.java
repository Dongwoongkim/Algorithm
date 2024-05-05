import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] check;
    static int ans = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n + 1][n + 1];
        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            check = new boolean[n + 1][n + 1];

            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] >= i && check[j][k] == false) {
                        bfs(j, k, i);
                        cnt++;
                    }
                }
            }
            
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }

    private static void bfs(int x, int y, int max) {
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
                    if (arr[nextX][nextY] >= max && check[nextX][nextY] == false) {
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
