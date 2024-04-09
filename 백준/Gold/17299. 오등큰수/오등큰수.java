import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> st = new Stack<>();
    static int[] count = new int[1_000_001];
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        StringTokenizer stt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
            count[arr[i]]++;
        }

        st.push(arr[n - 1]);
        ans.add(-1);

        for (int i = n - 2; i >= 0; i--) {
            while (true) {
                if (st.isEmpty() || count[arr[i]] < count[st.peek()]) {
                    break;
                } else {
                    st.pop();
                }
            }

            if (st.isEmpty()) {
                ans.add(-1);
                st.push(arr[i]);
            }

            if (!st.isEmpty() && count[arr[i]] < count[st.peek()]) {
                ans.add(st.peek());
                st.push(arr[i]);
            }
        }

        Collections.reverse(ans);

        for (Integer i : ans) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
