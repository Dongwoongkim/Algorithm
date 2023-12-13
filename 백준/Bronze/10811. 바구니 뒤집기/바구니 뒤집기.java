import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> basket = new ArrayList<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            basket.add(i, i);
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for (int j = start; j <= (start + end) / 2; j++) {
                Integer tmp = basket.get(j);
                basket.set(j, basket.get(end - j + start));
                basket.set(end - j + start, tmp);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(basket.get(i) + " ");
        }
    }
}
