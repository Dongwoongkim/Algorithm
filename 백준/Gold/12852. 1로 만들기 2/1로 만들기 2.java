import java.util.Scanner;

public class Main {

    static int[] dp = new int[1_000_001];
    static int[] previous = new int[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp[1] = 0;
        dp[2] = 1;
        previous[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            previous[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                previous[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                previous[i] = i / 3;
            }
        }

        System.out.println(dp[n]);

        StringBuilder sb = new StringBuilder();

        int current = n;

        while (current != 0) {
            if (current != 1) {
                sb.append(current).append(" ");
            }

            if (current == 1) {
                sb.append(current);
                break;
            }
            current = previous[current];
        }

        System.out.print(sb);
    }
}
