import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] rgb = new int[n + 1][4];
        int[][] dp = new int[n + 1][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = rgb[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1] + rgb[i][j], dp[i - 1][2] + rgb[i][j]);
                }

                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0] + rgb[i][j], dp[i - 1][2] + rgb[i][j]);
                }

                if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][0] + rgb[i][j], dp[i - 1][1] + rgb[i][j]);
                }
            }
        }

        System.out.print(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
