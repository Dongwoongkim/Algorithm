import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] t = new int[16];
    static int[] p = new int[16];
    static int[] dp;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            // 상담 가능한 경우
            if (i + t[i] <= n + 1) {
                // 상담 안하기 vs 상담하기
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
                
                ans = Math.max(ans, dp[i]);
                continue;
            }

            // 상담 불가능한 경우 -> 다음날 거 가져오기
            dp[i] = dp[i + 1];
        }

        System.out.println(ans);
    }
}
