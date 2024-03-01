import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[n + 1][n + 1];

        int start = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < start; j++) {
                dp[i][j] = sc.nextInt();
            }
            start++;
        }

        start = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= start; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j] + dp[i][j], dp[i - 1][j - 1] + dp[i][j]);
            }
            start++;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }
}
