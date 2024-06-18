import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> st = new Stack<>();

        boolean tag = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(ch);
                tag = true;
                continue;
            }
            if (ch == '>') {
                sb.append(ch);
                tag = false;
                continue;
            }
            if (tag) {
                sb.append(ch);
                continue;
            }

            if (ch == ' ') {
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
                sb.append(ch);
                continue;
            }
            st.push(ch);

        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb.toString());
    }
}
