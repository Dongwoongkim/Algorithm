import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // nCr = n! / (n-r)!r!

        // nCr의 2의 지수
        // n을 소인수분해했을때 2의 지수 - m을 소인수분해했을떄 2의 지수 - (n-m)을 소인수분해했을때 2의 지수
        // 지수 곱은 합으로 계산할수 있으므로
        int twoCnt = get(n, 2) - (get(m, 2) + get(n - m, 2));

        // nCr의 5의 지수
        // n을 소인수분해했을때 5의 지수 - (m을 소인수분해 했을때 5의 지수 + (n-m)을 소인수분해 했을때 5의 지수)
        int fiveCnt = get(n, 5) - (get(m, 5) + get(n - m, 5));

        System.out.println(Math.min(twoCnt, fiveCnt));

    }

    private static int get(int n, int k) {
        int cnt = 0;

        while (n >= k) {
            cnt += n / k;
            n /= k;
        }

        return cnt;
    }
}
