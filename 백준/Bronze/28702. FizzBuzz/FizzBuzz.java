import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> inputs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            inputs.add(br.readLine());
        }

        int numberIdx = getNumberIdx(inputs);
        int number = Integer.parseInt(inputs.get(numberIdx));

        int next = -1;
        if (numberIdx == 0) {
            next = number + 3;
        }
        if (numberIdx == 1) {
            next = number + 2;
        }
        if (numberIdx == 2) {
            next = number + 1;
        }

        System.out.println(피즈버즈ㅋㅋ(next));
    }

    private static int getNumberIdx(List<String> inputs) {
        for (int i = 0; i < 3; i++) {
            try {
                Integer.parseInt(inputs.get(i));
                return i;
            } catch (NumberFormatException e) {
            }
        }
        return -1;
    }

    private static String 피즈버즈ㅋㅋ(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        }
        if (n % 3 == 0) {
            return "Fizz";
        }
        if (n % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(n);
    }
}
