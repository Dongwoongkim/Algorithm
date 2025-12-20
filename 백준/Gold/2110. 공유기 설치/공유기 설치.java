import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, c;
    static long[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        length = new long[n + 1];

        for (int i = 0; i < n; i++) {
            length[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(length, 0, n);

        System.out.print(binarySearch());
    }

    private static long binarySearch() {
        long start = 1;
        long end = length[n - 1] - length[0];
        long ans = 0L;

        while (start <= end) {
            long mid = (start + end) / 2;

            int cnt = 1;
            int pos = 0;
            for (int i = 1; i < n; i++) {
                long distance = length[i] - length[pos];
                if (distance >= mid) {
                    cnt++;
                    pos = i;
                }
            }

//            System.out.println(mid + " " + cnt);

            if (cnt < c) {
                end = mid - 1;
            }

            if (cnt >= c) {
                start = mid + 1;
                ans = mid;
            }
        }

        return ans;
    }
}
