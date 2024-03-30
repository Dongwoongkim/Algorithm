import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = 1;
        while (true) {
            String line = br.readLine();

            if (line.startsWith("-")) {
                break;
            }

            Stack<Character> st = new Stack<>();

            int cnt = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '{') {
                    st.push('{');
                }

                if (line.charAt(i) == '}') {
                    if (st.isEmpty()) {
                        st.push('{');
                        cnt++;
                        continue;
                    }

                    if (st.peek().equals('{')) {
                        st.pop();
                    }
                }
            }

            sb.append(k + ". " + (cnt + st.size() / 2)).append("\n");
            k++;
        }
        System.out.println(sb);
    }
}
