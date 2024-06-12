import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int ans = Integer.MIN_VALUE;
    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = v;
        }

        dfs(1, 0);

        System.out.println(ans);
    }

    private static void dfs(int next, int sum) {
        if (next > n) {
            ans = Math.max(ans, sum);
            return;
        }

        dfs(next + 1, sum);
        dfs(next + 2, sum + arr[next]);
    }
}
