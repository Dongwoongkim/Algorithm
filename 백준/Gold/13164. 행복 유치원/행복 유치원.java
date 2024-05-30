import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i < n; i++) {
            pq.add(arr[i] - arr[i - 1]);
        }
        
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);

    }

    static class Top {

        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}
