import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int ans = 50 * 50;
    static boolean isAnswerExists = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] area;
    static List<Position> virusArea = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        area = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = sc.nextInt();
                if (area[i][j] == 2) {
                    virusArea.add(new Position(i, j));
                }
            }
        }

        check = new boolean[virusArea.size()];

        for (int i = 0; i < virusArea.size(); i++) {
            dfs(i, 1);
        }

        if (isAnswerExists) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    private static void dfs(int pos, int cnt) {
        check[pos] = true;

        if (cnt == m) {
            Queue<Position> virus = new LinkedList<>();

            for (int i = 0; i < virusArea.size(); i++) {
                if (check[i] == true) {
                    virus.add(new Position(virusArea.get(i).x, virusArea.get(i).y));
                }
            }

            int result = bfs(virus);
            if (result != -1) {
                ans = Math.min(ans, result);
            }

            check[pos] = false;

            return;
        }

        for (int i = pos + 1; i < virusArea.size(); i++) {
            if (check[i] == false) {
                check[i] = true;
                dfs(i, cnt + 1);
                check[i] = false;
            }
        }

        check[pos] = false;
    }

    private static int bfs(Queue<Position> virus) {
        int cnt = -1;
        int[][] tmp = new int[n + 1][n + 1];
        boolean[][] check = new boolean[n + 1][n + 1];
        boolean[][] originVirus = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 벽이면 -1
                if (area[i][j] == 1) {
                    tmp[i][j] = -1;
                }
                // 비활성 바이러스 -2
                if (area[i][j] == 2) {
                    tmp[i][j] = -2;
                }
            }
        }

        // 활성 바이러스 1로 변경
        for (Position position : virus) {
            tmp[position.x][position.y] = 1;
        }

        while (!virus.isEmpty()) {
            Position poll = virus.poll();
            int curX = poll.x;
            int curY = poll.y;

            check[curX][curY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (tmp[nextX][nextY] == 0 && check[nextX][nextY] == false) {
                        tmp[nextX][nextY] = tmp[curX][curY] + 1;
                        virus.add(new Position(nextX, nextY));
                    }
                    if (tmp[nextX][nextY] == -2 && check[nextX][nextY] == false) {
                        tmp[nextX][nextY] = tmp[curX][curY] + 1;
                        originVirus[nextX][nextY] = true;
                        virus.add(new Position(nextX, nextY));
                    }
                }
            }
        }

        if (allAreaSpread(check, tmp)) {
            isAnswerExists = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tmp[i][j] != -1 && originVirus[i][j] == false) {
                        cnt = Math.max(cnt, tmp[i][j]);
                    }
                }
            }

            return cnt - 1;
        }

        return -1;
    }

    private static boolean allAreaSpread(boolean[][] check, int[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] != -1 && tmp[i][j] != -2 && check[i][j] == false) {
                    return false;
                }
            }
        }

        return true;
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
