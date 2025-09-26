import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int n;
    static boolean possible = true;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        int cur = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > cur) {
                for (int j = cur + 1; j <= x; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                cur = x;
            }

            if (stack.isEmpty() || stack.peek() != x) {
                possible = false;
                break;
            }
            
            if (!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
                sb.append("-\n");
            }

        }

        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
