import java.util.Scanner;

public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n + 2];

        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2];

            for (int j = i - 4; j >= 0; j -= 2) {
                if (j == 0) {
                    // 짝수 번째에는 각각 특이한 케이스가 2개씩 있음 (이유는 모름)
                    dp[i] += 2;
                    continue;
                }

                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[n]);
    }
}
