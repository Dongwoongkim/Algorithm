import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        String explosion = br.readLine();

        char last = explosion.charAt(explosion.length() - 1);

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            st.push(line.charAt(i));

            if (st.peek().equals(last)) {
                String a = "";

                if (st.size() >= explosion.length()) {
                    for (int j = 0; j < explosion.length(); j++) {
                        a += st.pop();
                    }
                }

                String aReverse = new StringBuilder(a).reverse().toString();

                if (!explosion.equals(aReverse)) {
                    for (int j = 0; j < aReverse.length(); j++) {
                        st.push(aReverse.charAt(j));
                    }
                }
            }
        }

        if (st.isEmpty()) {
            System.out.println("FRULA");
            return;
        } else {
            for (Character c : st) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
