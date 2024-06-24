import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            int[] sum = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] += arr[i] + sum[i - 1];
            }

            for (int gap = 1; gap < n; gap++) {
                for (int i = 1; i <= n - gap; i++) {
                    int start = i;
                    int end = i + gap;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        // dp[start][mid] -> 시작부터 중간지점까지 합치는데 최소 비용
                        // dp[mid+1][end] -> 중간지점+1부터 end까지 합치는데 최소 비용
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + (sum[end] - sum[start - 1]));
                    }
                }
            }

            System.out.println(dp[1][n]);
        }
    }
}
