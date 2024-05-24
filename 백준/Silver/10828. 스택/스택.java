import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push")) {
                stack.push(Integer.parseInt(s[1]));
            }

            if (s[0].equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }

            if (s[0].equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            }

            if (s[0].equals("size")) {
                sb.append(stack.size()).append("\n");
            }

            if (s[0].equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
