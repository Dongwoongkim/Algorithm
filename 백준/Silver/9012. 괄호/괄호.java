import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            sb.append(getAnswer(line)).append("\n");
        }

        System.out.println(sb);
    }

    private static String getAnswer(String line) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                st.push('(');
                continue;
            }

            if (line.charAt(i) == ')' && !st.isEmpty()) {
                st.pop();
                continue;
            }

            if (line.charAt(i) == ')' && st.isEmpty()) {
                return "NO";
            }
        }

        if (!st.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
}
