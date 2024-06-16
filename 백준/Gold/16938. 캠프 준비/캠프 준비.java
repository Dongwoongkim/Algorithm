import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] problem;
    static boolean[] check;
    static int ans = 0;
    static int n, l, r, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        problem = new int[n + 1];
        check = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(rec(1));
    }

    private static int rec(int cur) {
        if (cur == n + 1) {
            int cnt = 0;
            int sum = 0;
            int max = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= n; i++) {
                if (check[i] == true) {
                    cnt++;
                    sum += problem[i];
                    min = Math.min(min, problem[i]);
                    max = Math.max(max, problem[i]);
                }
            }

            if (cnt >= 2 && l <= sum && sum <= r && x <= (max - min)) {
                return 1;
            }

            return 0;
        }

        // 현재 문제 고르는 경우
        check[cur] = true;
        int cnt1 = rec(cur + 1);
        check[cur] = false;

        // 현재 문제 고르지 않는 경우
        int cnt2 = rec(cur + 1);

        return cnt1 + cnt2;
    }
}
