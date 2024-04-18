import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int idx = 0;

        String[] split = line.split("[.]");
        for (String s : split) {
            if (s.length() % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }

        while (true) {
            if (idx >= line.length()) {
                break;
            }

            if (idx + 4 <= line.length() && line.substring(idx, idx + 4).equals("XXXX")) {
                System.out.print("AAAA");
                idx += 4;
                continue;
            }

            if (idx + 2 <= line.length() && line.substring(idx, idx + 2).equals("XX")) {
                System.out.print("BB");
                idx += 2;
                continue;
            }

            System.out.print(line.charAt(idx));
            idx++;
        }
    }
}
