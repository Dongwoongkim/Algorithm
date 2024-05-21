import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int n;
    static int[] arr;
    static List<Integer> increase = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        n = sc.nextInt();
        arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int length = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        increase.add(arr[0]);

        for (int i = 1; i < n; i++) {
            int searchNum = arr[i];

            if (searchNum > increase.get(increase.size() - 1)) {
                increase.add(arr[i]);
                dp[i] = length;
                length++;
            } else {
                int idx = binarySearch(searchNum, increase);
                increase.set(idx, arr[i]);
                dp[i] = idx;
            }
        }

        int l = increase.size();
        System.out.println(l);
        
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == l - 1) {
                st.add(arr[i]);
                l--;
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int searchNum, List<Integer> increase) {
        int start = 0;
        int end = increase.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int middleNum = increase.get(mid);

            if (middleNum < searchNum) {
                start = mid + 1;
            }
            if (middleNum >= searchNum) {
                end = mid;
            }
        }

        return start;
    }
}
