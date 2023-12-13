import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            List<String> numbers = Arrays.stream(s.split(" ")).collect(Collectors.toList());

            System.out.println(numbers.stream()
                    .mapToInt(Integer::parseInt)
                    .sum());
        }
    }
}
