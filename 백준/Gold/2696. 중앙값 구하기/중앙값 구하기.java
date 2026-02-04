import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int t, n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
                Collections.reverseOrder()
            );
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            n = Integer.parseInt(br.readLine());
            sb.append((n + 1) / 2).append("\n");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n / 10; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr.add(Integer.parseInt(st.nextToken()));
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n % 10; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < n; i++) {
                int num = arr.get(i);

                if (i % 2 == 0) {
                    maxQueue.add(num);
                }

                if (i % 2 == 1) {
                    minQueue.add(num);
                }

                if (i >= 1) {
                    if (maxQueue.peek() > minQueue.peek()) {
                        Integer maxNum = maxQueue.poll();
                        Integer minNum = minQueue.poll();

                        maxQueue.add(minNum);
                        minQueue.add(maxNum);
                    }
                }

                if (i % 2 == 0) {
                    sb.append(maxQueue.peek()).append(" ");
                    if ((i / 2 + 1) % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}