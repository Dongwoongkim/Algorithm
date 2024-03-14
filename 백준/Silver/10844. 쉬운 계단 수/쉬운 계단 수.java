import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int l = 0; l <= 9; l++) {
                if (l == 0) {
                    dp[i][l] = dp[i - 1][1] % 1000000000;
                    continue;
                }

                if (l == 9) {
                    dp[i][l] = dp[i - 1][8] % 1000000000;
                    continue;
                }

                dp[i][l] = (dp[i - 1][l + 1] % 1000000000) + (dp[i - 1][l - 1] % 1000000000);
            }
        }

        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[n][i] % 1000000000;
        }
        System.out.println(ans % 1000000000);
    }
}
