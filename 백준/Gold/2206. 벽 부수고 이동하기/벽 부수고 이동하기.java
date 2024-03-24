import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1][2];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        check[x][y][0] = true;
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y, 1, 0));

        while (!q.isEmpty()) {
            Position position = q.peek();
            q.poll();

            int currentX = position.x;
            int currentY = position.y;
            int currentMove = position.move;
            int broke = position.broke;

            if ((currentX == n - 1) && (currentY == m - 1)) {
                return currentMove;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    // 벽인 경우
                    if (map[nextX][nextY] == 1 && broke < 1 && check[nextX][nextY][broke + 1] == false) {
                        check[nextX][nextY][broke + 1] = true;
                        q.add(new Position(nextX, nextY, currentMove + 1, broke + 1));
                    }

                    // 벽이 아닌 경우
                    else if (map[nextX][nextY] == 0 && check[nextX][nextY][broke] == false) {
                        check[nextX][nextY][broke] = true;
                        q.add(new Position(nextX, nextY, currentMove + 1, broke));
                    }
                }
            }
        }

        return -1;
    }

    static class Position {
        int x;
        int y;
        int move;
        int broke;

        public Position(int x, int y, int move, int broke) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.broke = broke;
        }
    }
}
