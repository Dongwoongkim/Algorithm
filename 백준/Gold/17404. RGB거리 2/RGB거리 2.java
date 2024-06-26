import java.util.Scanner;

public class Main {

    static int[][] rgb;
    static int n;
    static int ans = 1000 * 1000 + 1;
    static int max = 1000 * 1000 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        rgb = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = sc.nextInt();
            }
        }

        for (int start = 0; start < 3; start++) {
            int[][] dp = new int[n + 1][3];

            for (int i = 0; i < 3; i++) {
                if (i == start) {
                    dp[0][i] = rgb[0][i];
                }
                if (i != start) {
                    dp[0][i] = max;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i == start) {
                    continue;
                }
                ans = Math.min(ans, dp[n - 1][i]);
            }
        }
        System.out.println(ans);
    }
}
