import java.util.Scanner;

public class Main {

    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000;
            }
        }
        System.out.println(dp[n][k] % 1_000_000_000);

    }
}
