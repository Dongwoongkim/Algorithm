import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] LCS = new int[b.length() + 2][a.length() + 2];

        for (int i = 0; i <= b.length(); i++) {
            for (int j = 0; j <= a.length(); j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                    continue;
                }

                if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                }

                if (a.charAt(j - 1) != b.charAt(i - 1)) {
                    LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
                }
            }
        }

        System.out.println(LCS[b.length()][a.length()]);
    }
}
