import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int length = 100_001;

        int p0 = 0;
        int p1 = 0;
        int sum = 0;

        while (p0 <= n && p1 <= n) {
            if (sum < k) {
                sum += arr[p1];
                p1++;
                continue;
            }
            
            if (sum >= k) {
                length = Math.min(length, p1 - p0);
                sum -= arr[p0];
                p0++;
            }
        }

        if (length == 100_001) {
            System.out.println(0);
            return;
        }

        System.out.println(length);
    }
}
