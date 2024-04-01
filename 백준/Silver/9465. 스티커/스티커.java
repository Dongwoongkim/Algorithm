import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[][] = new int[2][n + 2];
            int dp[][] = new int[2][n + 2];

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1] + arr[0][j], dp[1][j - 2] + arr[0][j]);
                dp[1][j] = Math.max(dp[0][j - 1] + arr[1][j], dp[0][j - 2] + arr[1][j]);
            }

            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}
