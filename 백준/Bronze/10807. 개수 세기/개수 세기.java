import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            numbers.add(sc.nextInt());
        }

        int find = sc.nextInt();
        long count = numbers.stream().filter(n -> n.equals(find)).count();
        System.out.print(count);
    }
}
