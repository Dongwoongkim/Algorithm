import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int h;
    static Queue<Tomato> q = new LinkedList<>();
    static int[][][] result;
    static int[][][] box;
    static boolean[][][] check;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        box = new int[m + 1][n + 1][h + 1];
        result = new int[m + 1][n + 1][h + 1];
        check = new boolean[m + 1][n + 1][h + 1];

        for (int l = 0; l < h; l++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    box[i][j][l] = sc.nextInt();
                    if (box[i][j][l] == 1) {
                        q.add(new Tomato(i, j, l, 0));
                    }
                }
            }
        }

        bfs();
        System.out.println(getAns());
    }

    private static int getAns() {
        int ans = -1;
        for (int l = 0; l < h; l++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j][l] == false && box[i][j][l] != -1) {
                        return -1;
                    }
                    ans = Math.max(ans, result[i][j][l]);
                }
            }
        }

        return ans;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int z = q.peek().z;

            int day = q.peek().day;

            result[x][y][z] = day;
            check[x][y][z] = true;
            q.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];
                if (nextX < m && nextY < n && nextZ < h && nextX >= 0 && nextY >= 0 && nextZ >= 0) {
                    if (check[nextX][nextY][nextZ] == false && box[nextX][nextY][nextZ] == 0) {
                        check[nextX][nextY][nextZ] = true;
                        q.add(new Tomato(nextX, nextY, nextZ, day + 1));
                    }
                }
            }
        }
    }


    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}
