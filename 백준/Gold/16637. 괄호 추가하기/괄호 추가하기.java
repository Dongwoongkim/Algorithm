import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int ans = Integer.MIN_VALUE;
    static String line;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        line = br.readLine();
        rec(0, Integer.parseInt(String.valueOf(line.charAt(0))));
        System.out.println(ans);
    }

    private static void rec(int cur, int sum) {
        if (cur == n - 1) {
            ans = Math.max(ans, sum);
            return;
        }

        // 안 묶기
        char op1 = line.charAt(cur + 1);
        int result = calculate(sum, Integer.parseInt(String.valueOf(line.charAt(cur + 2))), op1);
        rec(cur + 2, result);

        // 묶기
        if (cur + 2 < n - 1) {
            char op2 = line.charAt(cur + 3);
            int result2 = calculate(Integer.parseInt(String.valueOf(line.charAt(cur + 2))),
                    Integer.parseInt(String.valueOf(line.charAt(cur + 4))), op2);

            rec(cur + 4, calculate(sum, result2, op1));
        }
    }

    private static int calculate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        }
        if (operator == '-') {
            return a - b;
        }

        return a * b;
    }
}

