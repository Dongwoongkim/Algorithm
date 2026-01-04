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

    // 연산자 우선순위
    // * / -> 1
    // + - -> 2
    // ( ) -> 3
    private static String getAnswer() {
        for (int i = 0; i < eq.length(); i++) {
            char ch = eq.charAt(i);

            // dq에 바로 추가
            if (ch == '(') {
                dq.addLast(ch);
                continue;
            }

            // dq에서 ( 나올떄까지 pop하고 출력
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
                // 비어있으면 dq add
                if (dq.isEmpty()) {
                    dq.addLast(ch);
                    continue;
                }

                // dq의 peek이 +나 - 만날떄까지 pop & 출력
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
                // 비어있으면 dq add
                if (dq.isEmpty()) {
                    dq.addLast(ch);
                    continue;
                }

                // dq의 peek이 ( 만날때까지 pop & 출력
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

            // 알파벳은 그냥 추가
            sb.append(ch);
        }

        while (!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }

        return sb.toString();
    }
}
