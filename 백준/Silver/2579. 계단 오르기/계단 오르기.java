import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] step = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 0; i < n; i++) {
            step[i] = sc.nextInt();
        }

        dp[0] = step[0];
        dp[1] = step[1] + step[0];
        dp[2] = Math.max(step[0] + step[2], step[1] + step[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + step[i], dp[i - 3] + step[i - 1] + step[i]);
        }

        System.out.println(dp[n - 1]);
    }
}
