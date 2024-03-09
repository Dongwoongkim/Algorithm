import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = -1;
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);

                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
}
