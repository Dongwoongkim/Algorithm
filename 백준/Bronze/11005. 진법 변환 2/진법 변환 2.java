import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<String> numberAndRadix = Arrays.stream(line.split(" ")).collect(Collectors.toList());

        int number = Integer.parseInt(numberAndRadix.get(0));
        int radix = Integer.parseInt(numberAndRadix.get(1));

        String answer = "";
        while (true) {
            if (number == 0) {
                break;
            }
            int c = number % radix;
            number /= radix;

            if (c >= 10) {
                answer += (char) (c + 55);
                continue;
            }
            answer += c;
        }

        for (int i = answer.length() - 1; i >= 0; i--) {
            System.out.print(answer.charAt(i));
        }
    }
}
