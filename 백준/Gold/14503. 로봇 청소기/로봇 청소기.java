import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int cnt = 0;
    static int[][] area;
    static boolean[][] check;

    //    북 동 남 서
    // d  0  1  2  3
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        area = new int[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];

        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        dfs(x, y, d);

        System.out.println(1 + cnt);
    }

    private static void dfs(int x, int y, int d) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextD = --d;
            if (nextD == -1) {
                d = 3;
                nextD = 3;
            }

            // 회전하고 앞으로 한 칸 전진
            int frontX = x + dx[nextD];
            int frontY = y + dy[nextD];

            if (isPositionInArea(frontX, frontY) && area[frontX][frontY] == 0 && check[frontX][frontY] == false) {
                // 청소 실시
                cnt++;
                dfs(frontX, frontY, nextD);
                return;
            }
        }
        if (isSurroundClean(x, y, area)) {

            if (d == 0) {
                int frontD = 2;
                int frontX = x + dx[frontD];
                int frontY = y + dy[frontD];
                if (isPositionInArea(frontX, frontY) && area[frontX][frontY] != 1) {
                    dfs(frontX, frontY, d);
                }
            }

            if (d == 1) {
                int frontD = 3;
                int frontX = x + dx[frontD];
                int frontY = y + dy[frontD];
                if (isPositionInArea(frontX, frontY) && area[frontX][frontY] != 1) {
                    dfs(frontX, frontY, d);
                }
            }

            if (d == 2) {
                int frontD = 0;
                int frontX = x + dx[frontD];
                int frontY = y + dy[frontD];
                if (isPositionInArea(frontX, frontY) && area[frontX][frontY] != 1) {
                    dfs(frontX, frontY, d);
                }
            }

            if (d == 3) {
                int frontD = 1;
                int frontX = x + dx[frontD];
                int frontY = y + dy[frontD];
                if (isPositionInArea(frontX, frontY) && area[frontX][frontY] != 1) {
                    dfs(frontX, frontY, d);
                }
            }
        }
    }

    private static boolean isSurroundClean(int curX, int curY, int[][] area) {
        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            // 영역 안에 있으면서 청소되지 않은 칸이 있는 경우
            if (isPositionInArea(nextX, nextY) && area[nextX][nextY] == 0 && check[nextX][nextY] == false) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPositionInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
