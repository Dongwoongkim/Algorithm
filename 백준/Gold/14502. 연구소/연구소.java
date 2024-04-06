import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int k = 0;
    static int ans = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] area;
    static Queue<Position> virus = new LinkedList<>();
    static List<Position> zeroArea = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        area = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
                if (area[i][j] == 0) {
                    zeroArea.add(new Position(i, j));
                }
            }
        }

        check = new boolean[zeroArea.size()];

        for (int i = 0; i < zeroArea.size(); i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    private static void dfs(int pos, int cnt) {
        check[pos] = true;

        if (cnt == 2) {
            for (int i = 0; i < zeroArea.size(); i++) {
                if (check[i]) {
                    area[zeroArea.get(i).x][zeroArea.get(i).y] = 1;
                }
            }

            ans = Math.max(ans, bfs());

            for (int i = 0; i < zeroArea.size(); i++) {
                if (check[i]) {
                    area[zeroArea.get(i).x][zeroArea.get(i).y] = 0;
                }
            }

            return;
        }

        for (int i = pos + 1; i < zeroArea.size(); i++) {
            if (check[i] == false) {
                check[i] = true;
                dfs(i, cnt + 1);
                check[i] = false;
            }
        }

        check[pos] = false;
    }

    private static int bfs() {
        int cnt = 0;
        Queue<Position> q = new LinkedList<>();
        int[][] tmp = new int[n + 1][m + 1];
        boolean[][] check = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (area[i][j] == 2) {
                    q.add(new Position(i, j));
                }
                tmp[i][j] = area[i][j];
            }
        }

        while (!q.isEmpty()) {
            Position poll = q.poll();
            int curX = poll.x;
            int curY = poll.y;

            check[curX][curY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (tmp[nextX][nextY] == 0 && check[nextX][nextY] == false) {
                        tmp[nextX][nextY] = 2;
                        q.add(new Position(nextX, nextY));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
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
