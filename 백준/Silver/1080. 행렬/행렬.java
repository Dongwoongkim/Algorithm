import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] a;
    static char[][] b;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new char[n + 1][m + 1];
        b = new char[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    change(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void change(int startX, int startY) {
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (a[i][j] == '1') {
                    a[i][j] = '0';
                    continue;
                }
                if (a[i][j] == '0') {
                    a[i][j] = '1';
                }
            }
        }
    }
}
