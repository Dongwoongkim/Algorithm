import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] lcs = new int[4001][4001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(i)) {
                    if (i == 0 || j == 0) {
                        lcs[i][j] = 1;
                        continue;
                    }
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                ans = Math.max(ans, lcs[i][j]);
            }
        }

        System.out.println(ans);
    }
}
