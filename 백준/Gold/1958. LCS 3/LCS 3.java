import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][][] lcs = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                for (int k = 1; k <= c.length(); k++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1)) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i][j - 1][k], Math.max(lcs[i][j][k - 1], lcs[i - 1][j][k]));
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                for (int k = 0; k <= c.length(); k++) {
                    ans = Math.max(ans, lcs[i][j][k]);
                }
            }
        }

        System.out.println(ans);
    }
}
