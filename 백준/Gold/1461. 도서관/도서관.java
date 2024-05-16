import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> negatives = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> positives = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num < 0) {
                negatives.add(-1 * num);
                continue;
            }
            positives.add(num);
        }

        int maxDistance = 0;

        // 음수만 존재하는 경우
        if (positives.isEmpty() && !negatives.isEmpty()) {
            maxDistance = negatives.peek();
        }
        // 양수만 존재하는 경우
        if (negatives.isEmpty() && !positives.isEmpty()) {
            maxDistance = positives.peek();
        }
        // 둘다 존재하는 경우
        if (!negatives.isEmpty() && !positives.isEmpty()) {
            maxDistance = Math.max(positives.peek(), negatives.peek());
        }

        int ans = 0;
        while (!positives.isEmpty()) {
            Integer go = positives.peek();
            for (int i = 0; i < m; i++) {
                if (positives.isEmpty()) {
                    break;
                }
                positives.poll();
            }
            ans += go + go;
        }

        while (!negatives.isEmpty()) {
            Integer go = negatives.peek();
            for (int i = 0; i < m; i++) {
                if (negatives.isEmpty()) {
                    break;
                }
                negatives.poll();
            }
            ans += go + go;
        }

        System.out.println(ans - maxDistance);
    }
}
