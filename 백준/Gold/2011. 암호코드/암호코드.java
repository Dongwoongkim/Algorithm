import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp = new int[5001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        dp[0] = 1;
        if (line.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= line.length(); i++) {
            // 한 글자씩 읽는경우
            if (line.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1] % 1000000;
            }

            if (i >= 2) {
                // 두글자씩 읽는 경우
                int num = Integer.parseInt("" + line.charAt(i - 2) + line.charAt(i - 1));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2] % 1000000;
                }
            }
        }

        System.out.println(dp[line.length()] % 1000000);
    }
}

