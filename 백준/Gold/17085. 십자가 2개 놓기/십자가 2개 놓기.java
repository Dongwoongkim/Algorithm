import java.util.Scanner;

public class Main {

    static int ans = -1;
    static char[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] area = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                area[i][j] = line.charAt(j);
            }
        }

        int ans = 0;

        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 < m; x1++) {
                // 십자가 1
                for (int l = 0; ; l++) {
                    // 범위밖
                    if (x1 - l < 0 || x1 + l >= m || y1 - l < 0 || y1 + l >= n) {
                        break;
                    }
                    if (area[y1][x1 + l] != '#' || area[y1 + l][x1] != '#' || area[y1][x1 - l] != '#'
                            || area[y1 - l][x1] != '#') {
                        break;
                    }
                    area[y1][x1 + l] = '*';
                    area[y1][x1 - l] = '*';
                    area[y1 + l][x1] = '*';
                    area[y1 - l][x1] = '*';

                    // 십자가 2
                    for (int y2 = 0; y2 < n; y2++) {
                        for (int x2 = 0; x2 < m; x2++) {
                            for (int l2 = 0; ; l2++) {
                                if (x2 - l2 < 0 || x2 + l2 >= m || y2 - l2 < 0 || y2 + l2 >= n) {
                                    break;
                                }
                                if (area[y2][x2 + l2] != '#' || area[y2][x2 - l2] != '#' || area[y2 + l2][x2] != '#'
                                        || area[y2 - l2][x2] != '#') {
                                    break;
                                }
                                ans = Math.max((4 * l + 1) * (4 * l2 + 1), ans);
                            }
                        }
                    }
                }

                // 십자가 1 원상복구
                for (int l = 0; ; l++) {
                    if (x1 - l < 0 || x1 + l >= m || y1 - l < 0 || y1 + l >= n) {
                        break;
                    }
                    if (area[y1][x1 + l] != '*' || area[y1 + l][x1] != '*' || area[y1][x1 - l] != '*'
                            || area[y1 - l][x1] != '*') {
                        break;
                    }

                    area[y1][x1 + l] = '#';
                    area[y1][x1 - l] = '#';
                    area[y1 + l][x1] = '#';
                    area[y1 - l][x1] = '#';
                }
            }
        }

        System.out.println(ans);
    }
}
