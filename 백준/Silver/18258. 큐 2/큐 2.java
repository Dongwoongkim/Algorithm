import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        int back = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.contains("push")) {
                List<String> command = Arrays.stream(line.split(" ")).collect(Collectors.toList());
                int number = Integer.parseInt(command.get(1));
                back = number;
                q.add(number);
            }

            if (line.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(q.remove()).append("\n");
            }

            if (line.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(q.peek()).append("\n");
            }

            if (line.equals("back")) {
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(back).append("\n");
            }

            if (line.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                    continue;
                }
                sb.append(0).append("\n");
            }

            if (line.equals("size")) {
                sb.append(q.size()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
