import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Boolean> numbers = new HashMap<>();

        for (int i = 1; i <= 28; i++) {
            numbers.put(sc.nextInt(), true);
        }

        for (int i = 1; i <= 30; i++) {
            Boolean b = numbers.get(i);
            if (b == null) {
                System.out.println(i);
            }
        }
    }
}
