import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            numbers.put(sc.nextInt(), i);
        }

        Integer findNumber = numbers.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0);

        System.out.println(findNumber + "\n" + numbers.get(findNumber));

    }
}
