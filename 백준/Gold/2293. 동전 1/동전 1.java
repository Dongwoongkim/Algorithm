import java.util.Scanner;

public class Main {

    static int n;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] coin = new int[n + 1];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            // 1, 2, 5
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
