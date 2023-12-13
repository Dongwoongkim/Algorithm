import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            numbers.put(i, i);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int tmp = numbers.get(a);
            numbers.put(a, numbers.get(b));
            numbers.put(b, tmp);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
