import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            System.out.println(getAnswer(line));
        }
    }

    private static String getAnswer(String line) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                st.push('(');
                continue;
            }

            if (line.charAt(i) == '[') {
                st.push('[');
                continue;
            }

            if (line.charAt(i) == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
                continue;
            }

            if (line.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
                continue;
            }

            if (line.charAt(i) == ')' && (st.isEmpty() || st.peek() == '[')) {
                return "no";
            }

            if (line.charAt(i) == ']' && (st.isEmpty() || st.peek() == '(')) {
                return "no";
            }
        }

        if (!st.isEmpty()) {
            return "no";
        }

        return "yes";
    }
}
