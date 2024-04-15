import java.util.Scanner;
import java.util.Stack;

public class Main {

    static long ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            long[] arr = new long[n + 2];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            Stack<Index> st = new Stack<>();
            st.push(Index.of(0));

            for (int i = 1; i <= n + 1; i++) {
                while (!st.isEmpty()) {
                    int topIdx = st.peek().value;
                    if (arr[topIdx] <= arr[i]) {
                        break;
                    }
                    // 푸쉬하려는 길이가 이전 길이보다 작아질 때 넓이 계산
                    st.pop();
                    ans = Math.max(ans, arr[topIdx] * (i - st.peek().value - 1));
                }
                st.push(Index.of(i));
            }

            sb.append(ans).append("\n");
            ans = 0;
        }

        System.out.println(sb);
    }

    static class Index {
        int value;

        public static Index of(int idx) {
            return new Index(idx);
        }

        public Index(int idx) {
            this.value = idx;
        }
    }
}
