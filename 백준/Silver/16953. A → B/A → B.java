import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Map<Long, Integer> check = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line);

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<Long> queue = new LinkedList<>();

        queue.add(a);
        check.put(a, 0);

        while (!queue.isEmpty()) {
            long num = queue.poll();

            if (num == b) {
                System.out.println(check.get(num) + 1);
                return;
            }

            if (num * 2 <= b) {
                if (check.get(num * 2) == null) {
                    queue.add(num * 2);
                    check.put(num * 2, check.get(num) + 1);
                }
            }

            if (num * 10 + 1 <= b) {
                if (check.get(num * 10 + 1) == null) {
                    queue.add(num * 10 + 1);
                    check.put(num * 10 + 1, check.get(num) + 1);
                }
            }
        }

        System.out.println(-1);
    }
}
