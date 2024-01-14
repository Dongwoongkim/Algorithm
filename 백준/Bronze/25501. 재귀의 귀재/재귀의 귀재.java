import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            System.out.println(isPalindrome(line));
        }
    }

    private static String isPalindrome(String line) {
        return recursion(line, 0, line.length() - 1, 0);
    }

    private static String recursion(String line, int l, int r, int call) {
        if (l >= r) {
            return 1 + " " + (call + 1);
        }
        if (line.charAt(l) != line.charAt(r)) {
            return 0 + " " + (call + 1);
        }

        return recursion(line, l + 1, r - 1, call + 1);
    }
}
