import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] problem;
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

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }

        rec(1, Integer.MAX_VALUE, -1, 0);

        System.out.println(ans);
    }

    private static void rec(int cur, int min, int max, int sum) {
        if (cur == n + 1) {
            if (l <= sum && sum <= r && x <= (max - min)) {
                ans++;
                return;
            }
            return;
        }

        // 현재 문제 선택한 경우
        rec(cur + 1, Math.min(min, problem[cur]), Math.max(max, problem[cur]), sum + problem[cur]);

        // 현재 문제 선택 X
        rec(cur + 1, min, max, sum);
    }
}
