import java.util.Scanner;

public class Main {

    static int[][] dp;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n + 1];
        dp = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i];
            dp[i][1] = arr[i];
        }

        int ans = arr[0];
        
        for (int i = 1; i < n; i++) {
            // 현재 값 삭제하지 않는 경우
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);

            // 현재 값 삭제하는 경우 중 최댓값 = 이전항까지 삭제하지 않은 경우와 이전항을 삭제한값에 현재값을 더한값을 비교하여 더 큰 값
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(ans);
    }
}
