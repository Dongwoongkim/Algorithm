import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] gates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gates = new long[n + 1];

        for (int i = 0; i < n; i++) {
            gates[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(gates, 0, n);

        System.out.println(lowerBoundBinarySearch());

    }

    private static long lowerBoundBinarySearch() {
        long start = 1;
        long end = gates[n - 1] * m + 1;

        while (start < end) {
            long mid = (start + end) / 2;

            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / gates[i];
                if (cnt >= m) {
                    break;
                }
            }

            // mid 초 동안 m명보다 적게 통과하면 mid 늘리고
            if (cnt < m) {
                start = mid + 1;
            }

            // mid 초동안 m명보다 많거나 m명만큼 통과하면 mid 줄임
            if (cnt >= m) {
                end = mid;
            }

        }
        return start;
    }
}
