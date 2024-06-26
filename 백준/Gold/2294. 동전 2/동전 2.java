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

        for (int i = 1; i <= k; i++) {
            dp[i] = 100001;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if (dp[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
