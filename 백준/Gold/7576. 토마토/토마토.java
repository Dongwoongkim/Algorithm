import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static Queue<Tomato> q = new LinkedList<>();
    static int[][] result;
    static int[][] box;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        box = new int[m + 1][n + 1];
        result = new int[m + 1][n + 1];
        check = new boolean[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }

        bfs();
        System.out.println(getAns());
    }

    private static int getAns() {
        int ans = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false && box[i][j] != -1) {
                    return -1;
                }
                ans = Math.max(ans, result[i][j]);
            }
        }

        return ans;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int day = q.peek().day;

            result[x][y] = day;
            check[x][y] = true;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < m && nextY < n && nextX >= 0 && nextY >= 0) {
                    if (check[nextX][nextY] == false && box[nextX][nextY] == 0) {
                        check[nextX][nextY] = true;
                        q.add(new Tomato(nextX, nextY, day + 1));
                    }
                }
            }
        }
    }

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
