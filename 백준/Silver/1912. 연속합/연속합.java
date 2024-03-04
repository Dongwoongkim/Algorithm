import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        int ans = -1001;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
