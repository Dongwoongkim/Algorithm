import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        Deque<Ballon> dq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dq.add(new Ballon(i, sc.nextInt()));
        }

        while (dq.size() > 1) {
            Ballon ballon = dq.poll();
            sb.append(ballon.idx).append(" ");
            int next = ballon.next;

            if (next > 0) {
                for (int i = 0; i < next - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            }

            if (next < 0) {
                for (int i = 0; i < Math.abs(next); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        sb.append(dq.poll().idx).append(" ");
        System.out.println(sb);

    }

    private static class Ballon {

        private int idx;
        private int next;

        public Ballon(int idx, int next) {
            this.idx = idx;
            this.next = next;
        }
    }
}
