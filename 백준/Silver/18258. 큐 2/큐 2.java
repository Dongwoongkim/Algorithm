import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int back = -1;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] commands = line.split(" ");

            if (commands[0].equals("push")) {
                int number = Integer.parseInt(commands[1]);
                queue.add(number);
                back = number;
            }

            if (line.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }

            if (line.equals("size")) {
                sb.append(queue.size()).append("\n");
            }

            if (line.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }

            if (line.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            }

            if (line.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(back).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
