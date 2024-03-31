import java.util.Scanner;

public class Main {

    static long[][] dp = new long[100002][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[1][1] = 1;
        
        dp[2][2] = 1;
        
        dp[3][3] = 1;
        dp[3][2] = 1;
        dp[3][1] = 1;

        for (int i = 4; i <= 100001; i++) {
            // 수의 합이 i 면서 1로 끝나는 경우 
            // = (수의 합이 i-1이면서 2로 끝나는경우)에 1을 더하는 경우
            // = (수의 합이 i-1이면서 3으로 끝나는 경우)에 1을 더하는 경우
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1_000_000_009;

            // 수의 합이 i 면서 2로 끝나는 경우 
            // = (수의 합이 i-2이면서 1로 끝나는 경우)에 2을 더하는 경우
            // = (수의 합이 i-2이면서 3으로 끝나는 경우)에 2을 더하는 경우
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1_000_000_009;

            // 수의 합이 i 면서 3으로 끝나는 경우 
            // = (수의 합이 i-3이면서 3로 끝나는경우)에 3을 더하는 경우
            // = (수의 합이 i-3이면서 3으로 끝나는 경우)에 3을 더하는 경우
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1_000_000_009;
        }

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println((dp[num][1] + dp[num][2] + dp[num][3]) % 1_000_000_009);
        }
    }
}
