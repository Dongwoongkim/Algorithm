import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (true) {
            if (s.equals(t)) {
                System.out.println(1);
                break;
            }

            if (t.isBlank()) {
                System.out.println(0);
                break;
            }

            if (t.charAt(t.length() - 1) == 'A') {
                t = t.substring(0, t.length() - 1);
                continue;
            }

            if (t.charAt(t.length() - 1) == 'B') {
                t = t.substring(0, t.length() - 1);

                String tmp = "";

                for (int i = t.length() - 1; i >= 0; i--) {
                    tmp += t.charAt(i);
                }
                t = tmp;
            }
        }

    }
}
