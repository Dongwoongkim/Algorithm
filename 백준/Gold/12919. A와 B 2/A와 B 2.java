import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        rec(s, t);

        System.out.println(ans);

    }

    private static void rec(String s, String t) {
        if (s.equals(t)) {
            ans = 1;
            return;
        }

        if (t.length() < s.length()) {
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            rec(s, t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            String tmp = "";
            for (int i = t.length() - 1; i >= 0; i--) {
                tmp += t.charAt(i);
            }
            rec(s, tmp.substring(0, t.length() - 1));
        }
    }
}
