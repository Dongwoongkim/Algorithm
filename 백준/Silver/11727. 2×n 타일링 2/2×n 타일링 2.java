import java.util.Scanner;

public class Main {

    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[sc.nextInt()]);
    }
}
