import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[101];
        dp[1] = dp[2] = 1;
        dp[0] = 0;

        for (int i = 3; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
