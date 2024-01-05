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
        List<Integer> numbers = Arrays.stream(line.split(" "))
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());

        printAnswer(numbers);
    }

    private static void printAnswer(List<Integer> numbers) {
        Integer a = numbers.get(0);
        Integer b = numbers.get(1);
        Integer c = numbers.get(2);
        Integer d = numbers.get(3);
        Integer e = numbers.get(4);
        Integer f = numbers.get(5);

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.print(x + " " + y);
                    break;
                }
            }
        }
    }
}
