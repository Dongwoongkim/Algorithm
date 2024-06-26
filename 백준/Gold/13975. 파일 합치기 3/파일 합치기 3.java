import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> costs = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                costs.add(Long.parseLong(st.nextToken()));
            }

            long ans = 0;

            while (true) {
                if (costs.size() == 1) {
                    sb.append(ans).append("\n");
                    break;
                }

                Long num = costs.poll();
                Long num2 = costs.poll();

                ans += num + num2;
                costs.add(num + num2);
            }
        }
        System.out.println(sb);
    }
}
