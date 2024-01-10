import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            doCommand(command, sc, dq, sb);
        }

        System.out.print(sb);
    }

    private static void doCommand(int command, Scanner sc, Deque<Integer> dq, StringBuilder sb) {
        if (command == 1) {
            int number = sc.nextInt();
            dq.addFirst(number);
        }

        if (command == 2) {
            int number = sc.nextInt();
            dq.addLast(number);
        }

        if (command == 3) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            Integer number = dq.removeFirst();
            sb.append(number).append("\n");
        }

        if (command == 4) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            Integer number = dq.removeLast();
            sb.append(number).append("\n");
        }

        if (command == 5) {
            sb.append(dq.size()).append("\n");
        }

        if (command == 6) {
            if (dq.isEmpty()) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
        }

        if (command == 7) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(dq.getFirst()).append("\n");
        }

        if (command == 8) {
            if (dq.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(dq.getLast()).append("\n");
        }

    }
}
