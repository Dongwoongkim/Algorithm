import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static String eq;
    static Deque<Character> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eq = br.readLine();
        System.out.print(getAnswer());
    }

    private static String getAnswer() {
        for (int i = 0; i < eq.length(); i++) {
            char ch = eq.charAt(i);

            if (ch == '(') {
                dq.addLast(ch);
                continue;
            }

            if (ch == ')') {
                while (!dq.isEmpty()) {
                    char opr = dq.removeLast();
                    if (opr == '(') {
                        break;
                    }
                    sb.append(opr);
                }
                continue;
            }

            if (ch == '*' || ch == '/') {
                if (dq.isEmpty()) {
                    dq.addLast(ch);
                    continue;
                }

                while (!dq.isEmpty()) {
                    char opr = dq.peekLast();
                    if (opr == '*' || opr == '/') {
                        sb.append(dq.removeLast());
                    } else {
                        break;
                    }
                }
                dq.addLast(ch);
                continue;
            }

            if (ch == '+' || ch == '-') {
                if (dq.isEmpty()) {
                    dq.addLast(ch);
                    continue;
                }

                while (!dq.isEmpty()) {
                    char opr = dq.removeLast();
                    if (opr == '(') {
                        dq.addLast(opr);
                        break;
                    }
                    sb.append(opr);
                }
                dq.addLast(ch);
                continue;
            }

            sb.append(ch);
        }

        while (!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }

        return sb.toString();
    }
}
