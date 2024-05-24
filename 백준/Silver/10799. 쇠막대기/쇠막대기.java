import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                st.push('(');
            }

            if (line.charAt(i) == ')') {
                st.pop();

                if (line.charAt(i - 1) == ')') {
                    cnt++;
                } else {
                    cnt += st.size();
                }
            }
        }

        System.out.println(cnt);
    }
}
