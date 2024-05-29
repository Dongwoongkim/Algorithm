import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String ans;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        rec(0, n, "");

        System.out.println(ans);
    }

    private static void rec(int cnt, int n, String line) {
        if (isBadSequence(line) || flag) {
            return;
        }

        if (cnt == n) {
            if (!isBadSequence(line)) {
                flag = true;
                ans = line;
            }

            return;
        }

        for (int i = 1; i <= 3; i++) {
            rec(cnt + 1, n, line + i);
        }
    }

    private static boolean isBadSequence(String line) {

        for (int i = 1; i <= line.length() / 2; i++) {
            String line1 = line.substring(line.length() - i, line.length());
            String line2 = line.substring(line.length() - 2 * i, line.length() - i);

            if (line1.equals(line2)) {
                return true;
            }
        }

        return false;
    }
}
