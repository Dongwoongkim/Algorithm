import java.util.Scanner;

public class Main {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        dp[0][0][0] = 1;

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append(String.format("w(%d, %d, %d) = ", a, b, c));
            sb.append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    private static Integer w(int a, int b, int c) {
        if (a <= 20 && b <= 20 && c <= 20 &&
                a >= 0 && b >= 0 && c >= 0 &&
                dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            dp[20][20][20] = w(20, 20, 20);
            return dp[20][20][20];
        }

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1)
                    + w(a, b - 1, c - 1)
                    - w(a, b - 1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = w(a - 1, b, c)
                + w(a - 1, b - 1, c)
                + w(a - 1, b, c - 1)
                - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}
