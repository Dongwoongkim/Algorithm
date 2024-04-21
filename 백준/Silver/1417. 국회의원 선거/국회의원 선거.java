import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int first = sc.nextInt();

        for (int i = 1; i < n; i++) {
            pq.add(sc.nextInt());
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        while (true) {
            Integer num = pq.poll();
            if (num < first) {
                System.out.println(ans);
                break;
            }
            first++;
            ans++;
            pq.add(num - 1);
        }
    }
}
