import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            rec(1, n, "1", 1);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void rec(int cnt, int n, String line, int start) {
        if (cnt == n) {
            String expr = line.replaceAll(" ", "");

            int ans = calculate(expr);

            if (ans == 0) {
                sb.append(line).append("\n");
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            // +
            if (i == 1) {
                rec(cnt + 1, n, line + "+" + (start + 1), start + 1);
            }

            // -
            if (i == 2) {
                rec(cnt + 1, n, line + "-" + (start + 1), start + 1);
            }

            // ' '
            if (i == 0) {
                rec(cnt + 1, n, line + " " + (start + 1), start + 1);
            }
        }
    }

    private static int calculate(String expr) {
        StringTokenizer st = new StringTokenizer(expr, "+|-", true);

        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            String num = st.nextToken();

            if (op.equals("+")) {
                sum += Integer.parseInt(num);
            } else if (op.equals("-")) {
                sum -= Integer.parseInt(num);
            }
        }

        return sum;
    }
}
