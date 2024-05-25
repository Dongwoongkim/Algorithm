import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ' || Character.isDigit(line.charAt(i))) {
                sb.append(line.charAt(i));
                continue;
            }

            int value = line.charAt(i) + 13;

            if (Character.isUpperCase(line.charAt(i)) && value > 90) {
                sb.append((char) (value - 26));
                continue;
            }

            if (Character.isLowerCase(line.charAt(i)) && value > 122) {
                sb.append((char) (value - 26));
                continue;
            }
            sb.append(((char) value));
        }
        System.out.println(sb);
    }
}
