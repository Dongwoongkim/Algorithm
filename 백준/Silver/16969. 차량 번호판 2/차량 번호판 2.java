import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        long ans = 1;
        int d = 10;
        int c = 26;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'd') {
                ans = (ans * d) % 1_000_000_009;
                d = 9;
                c = 26;
            }

            if (line.charAt(i) == 'c') {
                ans = (ans * c) % 1_000_000_009;
                c = 25;
                d = 10;
            }
        }
        System.out.println(ans);
    }
}
