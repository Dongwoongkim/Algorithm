import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i - j] + arr[j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
