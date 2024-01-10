import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            doCommand(command, sc, st, sb);
        }

        System.out.print(sb);
    }

    private static void doCommand(int command, Scanner sc, Stack<Integer> st, StringBuilder sb) {
        if (command == 1) {
            int number = sc.nextInt();
            st.push(number);
        }

        if (command == 2) {
            if (!st.isEmpty()) {
                sb.append(st.pop()).append("\n");
                return;
            }
            sb.append(-1).append("\n");
        }

        if (command == 3) {
            sb.append(st.size()).append("\n");
        }

        if (command == 4) {
            if (st.isEmpty()) {
                sb.append(1).append("\n");
                return;
            }
            sb.append(0).append("\n");
        }

        if (command == 5) {
            if (st.isEmpty()) {
                sb.append(-1).append("\n");
                return;
            }
            sb.append(st.peek()).append("\n");
        }
    }
}
