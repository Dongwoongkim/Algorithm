import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        int sum = 0;
        int starPos = -1;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '*') {
                starPos = i;
                continue;
            }

            int numericValue = Character.getNumericValue(c);

            if (i % 2 == 0) {
                sum += numericValue;
            }

            if (i % 2 == 1) {
                sum += 3 * numericValue;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (starPos % 2 == 0 && (sum + i) % 10 == 0) {
                sb.append(i);
                break;
            }

            if (starPos % 2 == 1 && (sum + i * 3) % 10 == 0) {
                sb.append(i);
                break;
            }
        }
        System.out.print(sb);
    }
}
