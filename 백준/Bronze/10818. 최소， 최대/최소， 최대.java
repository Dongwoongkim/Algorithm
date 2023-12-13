import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            numbers.add(sc.nextInt());
        }

        List<Integer> sorted = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.print(sorted.get(0) + " " + sorted.get(numbers.size() - 1));
    }
}
