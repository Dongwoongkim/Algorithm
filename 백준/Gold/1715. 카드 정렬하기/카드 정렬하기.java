import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Integer num = pq.poll();

            if (pq.isEmpty()) {
                System.out.println(ans);
                break;
            }
            Integer num2 = pq.poll();

            pq.add(num + num2);
            ans += num + num2;
        }
    }
}

