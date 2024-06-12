import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
        }

        dp[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            // 전전꺼 선택하고 현재꺼 선택 vs 현재꺼 선택안하고 바로 이전꺼 선택한 선택
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }

}
