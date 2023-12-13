import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.print(1 - numbers.get(0) + " ");
        System.out.print(1 - numbers.get(1) + " ");
        System.out.print(2 - numbers.get(2) + " ");
        System.out.print(2 - numbers.get(3) + " ");
        System.out.print(2 - numbers.get(4) + " ");
        System.out.print(8 - numbers.get(5));
    }
}
