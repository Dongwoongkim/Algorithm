import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            int[][] area = new int[n + 1][m + 1];
            boolean[][] visited = new boolean[n + 1][m + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    area[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (area[i][j] == 1 && visited[i][j] == false) {
                        bfs(n, m, i, j, area, visited);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int n, int m, int x, int y, int[][] area, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 8; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInArea(n, m, nextX, nextY)) {
                    if (visited[nextX][nextY] == false && area[nextX][nextY] == 1) {
                        queue.add(new Position(nextX, nextY));
                        visited[curX][curY] = true;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    private static boolean isInArea(int n, int m, int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < n && nextY < m;
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
