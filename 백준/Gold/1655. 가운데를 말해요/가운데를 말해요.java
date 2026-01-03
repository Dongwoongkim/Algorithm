import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static StringBuilder sb;
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(
        Collections.reverseOrder()
    );
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                maxQueue.add(Integer.parseInt(br.readLine()));
            }

            if (i % 2 == 1) {
                minQueue.add(Integer.parseInt(br.readLine()));
            }

            if (i >= 1) {
                if (maxQueue.peek() > minQueue.peek()) {
                    Integer maxNum = maxQueue.poll();
                    Integer minNum = minQueue.poll();

                    maxQueue.add(minNum);
                    minQueue.add(maxNum);
                }
            }

            System.out.println(maxQueue.peek());
        }
    }
}
