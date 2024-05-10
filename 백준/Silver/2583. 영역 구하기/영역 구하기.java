import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] area = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();

            int endX = sc.nextInt();
            int endY = sc.nextInt();

            for (int x = startX; x < endX; x++) {
                for (int y = startY; y < endY; y++) {
                    area[x][y] = 1;
                }
            }
        }

        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 0 && visited[i][j] == false) {
                    pq.add(bfs(n, m, i, j, area, visited));
                    cnt++;
                }
            }
        }

        sb.append(cnt).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.print(sb);
    }

    private static int bfs(int n, int m, int x, int y, int[][] area, boolean[][] visited) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        int cnt = 1;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            if (visited[curX][curY] == false) {
                visited[curX][curY] = true;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInArea(n, m, nextX, nextY)) {
                    if (visited[nextX][nextY] == false && area[nextX][nextY] == 0) {
                        queue.add(new Position(nextX, nextY));
                        visited[nextX][nextY] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
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
