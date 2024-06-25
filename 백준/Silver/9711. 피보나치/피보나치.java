import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            BigInteger q = new BigInteger(st.nextToken());

            sb.append("Case #" + (i + 1) + ": " + dp[p].remainder(q)).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() {
        dp = new BigInteger[10001];

        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");

        for (int i = 2; i <= 10000; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
    }
}
