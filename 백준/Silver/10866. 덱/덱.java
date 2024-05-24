import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        int cur = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if (s[0].equals("push_front")) {
                queue.addFirst(Integer.parseInt(s[1]));
            }

            if (s[0].equals("push_back")) {
                queue.addLast(Integer.parseInt(s[1]));
            }

            if (s[0].equals("pop_front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.pollFirst()).append("\n");
                }
            }

            if (s[0].equals("pop_back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.pollLast()).append("\n");
                }
            }

            if (s[0].equals("size")) {
                sb.append(queue.size()).append("\n");
            }

            if (s[0].equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            
            if (s[0].equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.getFirst()).append("\n");
                }
            }

            if (s[0].equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.getLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
