import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int find = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            numbers.add(sc.nextInt());
        }

        String result = numbers.stream()
                .filter(n -> n < find)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.print(result);
    }
}
