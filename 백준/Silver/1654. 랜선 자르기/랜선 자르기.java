import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k, n;
    static long[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        length = new long[k + 1];

        for (int i = 0; i < k; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(length, 0, k);

        System.out.print(binarySearch());
    }

    private static long binarySearch() {
        long start = 1;
        long end = length[k - 1];
        long ans = -1;

        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < k; i++) {
                cnt += length[i] / mid;
            }


            if (cnt < n) {
                end = mid - 1;
            }

            if (cnt >= n) {
                ans = mid;
                start = mid + 1;
            }
        }

        return ans;

    }
}
