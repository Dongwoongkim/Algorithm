import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int number = sc.nextInt();

            if (number == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(priorityQueue.poll()).append("\n");
                continue;
            }

            priorityQueue.add(number);
        }

        System.out.print(sb);
    }
}
