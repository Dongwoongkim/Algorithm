import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("0")) {
                break;
            }

            System.out.println(getAnswer(line));
        }
    }

    private static String getAnswer(String line) {
        StringBuilder sb = new StringBuilder();

        if (line.equals(sb.append(line).reverse().toString())) {
            return "yes";
        }

        return "no";
    }
}
