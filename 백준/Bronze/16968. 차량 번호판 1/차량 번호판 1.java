import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int ans = 1;
        int d = 10;
        int c = 26;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'd') {
                ans *= d;
                d = 9;
                c = 26;
            }

            if (line.charAt(i) == 'c') {
                ans *= c;
                c = 25;
                d = 10;
            }
        }
        System.out.println(ans);
    }
}
