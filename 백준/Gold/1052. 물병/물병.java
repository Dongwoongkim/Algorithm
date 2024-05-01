import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if (n <= k) {
            System.out.println(0);
            return;
        }

        int pow = 0;
        while (n >= 1) {
            int prev = (int) Math.pow(2, pow);
            int next = (int) Math.pow(2, pow + 1);
            if (prev <= n && n < next) {
                pq.add(prev);
                pow = 0;
                n -= prev;
            } else {
                pow++;
            }
        }

        while (true) {
            if (pq.size() == k) {
                break;
            }

            Integer poll = pq.poll();

            if (pq.isEmpty()) {
                cnt = 0;
                break;
            }
            Integer num = pq.peek();

            cnt += num - poll;
            pq.poll();
            pq.add(num + num);
        }

        System.out.println(cnt);
    }
}
