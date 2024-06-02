import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] lcs = new int[4001][4001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {
                if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int ans = -1;

        int x = -1;
        int y = -1;

        for (int i = 0; i <= b.length(); i++) {
            for (int j = 0; j <= a.length(); j++) {
                if (ans <= lcs[i][j]) {
                    ans = lcs[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (lcs[x][y] == 0) {
                break;
            }
            if (lcs[x][y] != lcs[x - 1][y] && lcs[x][y] != lcs[x][y - 1]) {
                sb.append(b.charAt(x - 1));
                x--;
                y--;
                continue;
            }

            if (lcs[x][y] == lcs[x - 1][y]) {
                x--;
                continue;
            }

            if (lcs[x][y] == lcs[x][y - 1]) {
                y--;
            }
        }

        System.out.println(ans);
        System.out.println(sb.reverse());
    }
}
