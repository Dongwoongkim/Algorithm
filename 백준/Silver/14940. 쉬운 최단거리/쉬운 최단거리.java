import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] visited;
    static int[][] map;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new int[n + 1][m + 1];
        map = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == -1) {
                    sb.append(-1 + " ");
                    continue;
                }

                if (map[i][j] == 0 && visited[i][j] == -1) {
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[x][y] = 0;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (map[nextX][nextY] == 1 && visited[nextX][nextY] == -1) {
                        queue.add(new Position(nextX, nextY));
                        visited[nextX][nextY] = visited[curX][curY] + 1;
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
