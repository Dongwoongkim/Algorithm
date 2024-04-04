import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][][] check;
    static int n;
    static int m;
    static int k;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1][k + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        check[startX][startY][0] = true;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY, 1, 0, 0));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int curX = pos.x;
            int curY = pos.y;
            int curBreakWallCount = pos.breakWallCount;
            int curMoveCount = pos.moveCount;
            int curTime = pos.time;

            if (curX == (n - 1) && curY == (m - 1)) {
                return curMoveCount;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 범위 안에 있고
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    // 벽을 부수어야 하는 경우
                    if (map[nextX][nextY] == 1) {
                        // 낮인 경우 부순다.
                        if (curTime == 0 && curBreakWallCount < k
                                && check[nextX][nextY][curBreakWallCount + 1] == false) {
                            check[nextX][nextY][curBreakWallCount + 1] = true;
                            queue.add(new Position(nextX, nextY, curMoveCount + 1, curBreakWallCount + 1, 1));
                        }

                        // 밤인 경우 제자리에 머문다.
                        if (curTime == 1) {
                            check[curX][curY][curBreakWallCount] = true;
                            queue.add(new Position(curX, curY, curMoveCount + 1, curBreakWallCount, 0));
                        }
                    }

                    // 벽을 부수지 않는 경우
                    if (map[nextX][nextY] == 0 && check[nextX][nextY][curBreakWallCount] == false) {
                        check[nextX][nextY][curBreakWallCount] = true;

                        // 낮인 경우
                        if (curTime == 0) {
                            queue.add(new Position(nextX, nextY, curMoveCount + 1, curBreakWallCount, 1));
                        }

                        // 밤인 경우
                        if (curTime == 1) {
                            queue.add(new Position(nextX, nextY, curMoveCount + 1, curBreakWallCount, 0));
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static class Position {

        int x;
        int y;
        int moveCount;
        int breakWallCount;
        int time;

        public Position(int x, int y, int moveCount, int breakWallCount, int time) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
            this.breakWallCount = breakWallCount;
            this.time = time;
        }
    }
}
