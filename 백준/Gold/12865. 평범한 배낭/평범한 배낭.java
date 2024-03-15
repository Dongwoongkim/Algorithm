import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int limit = 0; limit <= k; limit++) {
            for (int i = 1; i <= n; i++) {
                // 담을 수 있는 경우
                if (w[i] <= limit) {
                    // dp[i - 1][k - w[i]](이전 물건까지 담은 가치) + v[i](현재 물건 가치) => 현재 물건을 담는 경우
                    // dp[i - 1][limit] => 현재 물건을 담지 않는 경우
                    dp[i][limit] = Math.max(dp[i - 1][limit - w[i]] + v[i], dp[i - 1][limit]);
                }

                // 담을 수 없는 경우
                if (w[i] > limit) {
                    // 현재 물건까지 고려한 가치 = 이전 물건까지만 고려한 가치
                    dp[i][limit] = dp[i - 1][limit];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
