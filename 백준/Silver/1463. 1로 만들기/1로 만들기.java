import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n * 3 + 1];

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = n;
        }

        for (int i = 1; i <= n; i++) {
            dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);
        }

        System.out.println(dp[n]);
    }
}
