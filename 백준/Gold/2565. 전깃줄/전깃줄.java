import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }

        int idx = 0;
        for (Integer value : map.values()) {
            arr[idx++] = value;
        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(n - ans);
    }
}
