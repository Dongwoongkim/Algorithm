import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int k;
    static int ans = 0;
    static int[][] area;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        area = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] == false) {
                    bfs(i, j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isPositionInArea(nextX, nextY) && check[nextX][nextY] == false) {
                    if (Math.abs(area[curX][curY] - area[nextX][nextY]) <= k) {
                        check[nextX][nextY] = true;
                        queue.add(new Position(nextX, nextY));
                    }
                }
            }
        }
    }

    private static boolean isPositionInArea(int curX, int curY) {
        return curX >= 0 && curY >= 0 && curX < n && curY < m;
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
