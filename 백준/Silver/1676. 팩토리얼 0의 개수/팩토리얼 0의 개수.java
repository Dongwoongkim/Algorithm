import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // n!의 2의 지수
        // n을 소인수분해했을때 2의 지수
        // 지수 곱은 합으로 계산할수 있으므로
        int twoCnt = get(n, 2);

        // n!에서 5의 지수
        // n을 소인수분해했을때 5의 지수
        int fiveCnt = get(n, 5);

        // n! = 2^(twoCnt) * 5^(fiveCnt) * ...
        // n! = (10)^(Math.min(twoCnt, fiveCnt)) * ...
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
