import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        Stack<Integer> st = new Stack<>();
        int ans = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        int idx = ans;

        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == idx) {
                st.push(arr[i]);
                idx--;
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.peek()).append(" ");
            st.pop();
        }
        
        System.out.println(ans);
        System.out.println(sb);
    }
}
