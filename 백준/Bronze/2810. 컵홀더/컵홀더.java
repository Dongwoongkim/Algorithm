import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        String line = br.readLine();

        String ans = "*";

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'S') {
                ans += "S*";
                continue;
            }

            if (line.charAt(i) == 'L') {
                i++;
                ans += "LL*";
            }
        }

        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '*') {
                cnt++;
            }
        }
        if (n <= cnt) {
            System.out.println(n);
        } else {
            System.out.println(cnt);
        }
    }
}
