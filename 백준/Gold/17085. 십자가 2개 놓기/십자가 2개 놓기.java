import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int ans = -1;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int ans = -1;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                // 십자가 1
                for (int size = 0; ; size++) {
                    if (x - size < 0 || y - size < 0 || x + size >= n || y + size >= m) {
                        break;
                    }

                    if (map[x - size][y] != '#' || map[x + size][y] != '#' ||
                            map[x][y - size] != '#' || map[x][y + size] != '#') {
                        break;
                    }

                    map[x + size][y] = '*';
                    map[x - size][y] = '*';
                    map[x][y + size] = '*';
                    map[x][y - size] = '*';

                    // 십자가 2
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < m; b++) {
                            for (int size2 = 0; ; size2++) {
                                if (a - size2 < 0 || b - size2 < 0 || a + size2 >= n || b + size2 >= m) {
                                    break;
                                }
                                if (map[a - size2][b] != '#' || map[a + size2][b] != '#' ||
                                        map[a][b - size2] != '#' || map[a][b + size2] != '#') {
                                    break;
                                }

                                int area = ((size) * 4 + 1) * ((size2) * 4 + 1);
                                ans = Math.max(ans, area);
                            }
                        }
                    }
                }

                // 십자가 1 원상복구
                for (int l = 0; ; l++) {
                    if (x - l < 0 || y - l < 0 || x + l >= n || y + l >= m) {
                        break;
                    }
                    if (map[x - l][y] != '*' || map[x + l][y] != '*' ||
                            map[x][y - l] != '*' || map[x][y + l] != '*') {
                        break;
                    }

                    map[x][y + l] = '#';
                    map[x][y - l] = '#';
                    map[x + l][y] = '#';
                    map[x - l][y] = '#';
                }
            }
        }

        return ans;
    }
}
