import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height > height) {
                    sb.append(stack.peek().num + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }

            stack.add(new Top(i, height));
        }

        // 6 9 5 7 4
        // 1 2 3 4 5
        System.out.println(sb);
    }

    static class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}
