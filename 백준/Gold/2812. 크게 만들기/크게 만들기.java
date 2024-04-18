import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(line.charAt(0) - '0'));

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            Integer num = Integer.valueOf(line.charAt(i) - '0');
            while (!stack.isEmpty() && cnt < k) {
                if (stack.peek() < num) {
                    stack.pop();
                    cnt++;
                } else {
                    break;
                }
            }

            stack.push(num);
        }

        int stackIdx = 0;
        int ansLength = n - k;

        for (Integer i : stack) {
            if (stackIdx == ansLength) {
                break;
            }
            stackIdx++;
            sb.append(i);
        }
        System.out.println(sb);
    }
}
