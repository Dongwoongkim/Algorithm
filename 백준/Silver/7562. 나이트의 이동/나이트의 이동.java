import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] chess;
    static boolean[][] check;
    static int[][] result;
    static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int dy[] = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            chess = new int[n + 1][n + 1];
            check = new boolean[n + 1][n + 1];
            result = new int[n + 1][n + 1];

            int fromX = sc.nextInt();
            int fromY = sc.nextInt();
            int toX = sc.nextInt();
            int toY = sc.nextInt();

            bfs(fromX, fromY, toX, toY, n);
            System.out.println(result[toX][toY]);
        }
    }

    private static void bfs(int fromX, int fromY, int toX, int toY, int n) {
        result[fromX][fromY] = 0;
        check[fromX][fromY] = true;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(fromX, fromY));

        while (!q.isEmpty()) {
            int currentX = q.peek().x;
            int currentY = q.peek().y;

            if (currentX == toX && currentY == toY) {
                break;
            }

            q.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (!check[nextX][nextY]) {
                        check[nextX][nextY] = true;
                        result[nextX][nextY] = result[currentX][currentY] + 1;
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
