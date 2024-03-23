import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int cabbage = sc.nextInt();

            int[][] area = new int[row][col];
            boolean[][] check = new boolean[row][col];

            for (int j = 0; j < cabbage; j++) {
                int cabbageRow = sc.nextInt();
                int cabbageCol = sc.nextInt();
                area[cabbageRow][cabbageCol] = 1;
            }

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (check[j][k] == false && area[j][k] == 1) {
                        bfs(j, k, check, area, row, col);
                        count++;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    private static void bfs(int x, int y, boolean[][] check, int[][] area, int row, int col) {
        check[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            int currentX = q.peek().x;
            int currentY = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                    if (area[nextX][nextY] == 1 && check[nextX][nextY] == false) {
                        check[nextX][nextY] = true;
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
