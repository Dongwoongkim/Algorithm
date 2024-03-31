import java.util.Scanner;

public class Main {

    static long[] dp = new long[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
