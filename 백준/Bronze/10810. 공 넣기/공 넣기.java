import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> basket = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int ball = sc.nextInt();

            for (int j = start; j <= end; j++) {
                basket.put(j, ball);
            }
        }

        String answer = "";
        for (int i = 1; i <= n; i++) {
            answer += basket.getOrDefault(i, 0) + " ";
        }
        System.out.print(answer);
    }
}
