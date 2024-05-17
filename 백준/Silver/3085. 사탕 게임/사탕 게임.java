import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int ans = Integer.MIN_VALUE;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    if (map[i][j] != map[i][j + 1]) {
                        swap(i, j, i, j + 1);
                        ans = Math.max(ans, longest(n));
                        swap(i, j, i, j + 1);
                    }
                }

                if (i + 1 < n) {
                    if (map[i][j] != map[i + 1][j]) {
                        swap(i, j, i + 1, j);
                        ans = Math.max(ans, longest(n));
                        swap(i, j, i + 1, j);
                    }
                }
            }
        }

        System.out.println(ans);

    }

    private static int longest(int size) {
        int ans = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 'C') {
                    ans = Math.max(ans, checkRow(i, j, size, 'C'));
                    ans = Math.max(ans, checkColumn(i, j, size, 'C'));
                }
                if (map[i][j] == 'Y') {
                    ans = Math.max(ans, checkRow(i, j, size, 'Y'));
                    ans = Math.max(ans, checkColumn(i, j, size, 'Y'));
                }
                if (map[i][j] == 'P') {
                    ans = Math.max(ans, checkRow(i, j, size, 'P'));
                    ans = Math.max(ans, checkColumn(i, j, size, 'P'));
                }
                if (map[i][j] == 'Z') {
                    ans = Math.max(ans, checkRow(i, j, size, 'Z'));
                    ans = Math.max(ans, checkColumn(i, j, size, 'Z'));
                }
            }
        }

        return ans;
    }

    private static int checkRow(int x, int y, int n, char k) {
        int cnt = 1;
        boolean sameLeft = true;
        boolean sameRight = true;
        for (int i = 1; i < n; i++) {
            if (y + i < n) {
                if (sameLeft == true && map[x][y + i] == k) {
                    cnt++;
                } else {
                    sameLeft = false;
                }
            }
            if (y - i >= 0) {
                if (sameRight == true && map[x][y - i] == k) {
                    cnt++;
                } else {
                    sameRight = false;
                }
            }
        }

        return cnt;
    }

    private static int checkColumn(int x, int y, int n, char k) {
        int cnt = 1;
        boolean sameUp = true;
        boolean sameDown = true;

        for (int i = 1; i < n; i++) {
            if (sameUp == true && x + i < n) {
                if (map[x + i][y] == k) {
                    cnt++;
                } else {
                    sameUp = false;
                }
            }

            if (x - i >= 0) {
                if (sameDown == true && map[x - i][y] == k) {
                    cnt++;
                } else {
                    sameDown = false;
                }
            }
        }

        return cnt;
    }

    private static void swap(int x, int y, int x1, int y1) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x][y];
        map[x][y] = tmp;
    }
}
