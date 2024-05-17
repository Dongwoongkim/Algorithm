import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int[] arr;
    static boolean[] check;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        check = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        dfs(0, 0);

        if (s == 0) {
            System.out.println(cnt - 1);
        } else {
            System.out.println(cnt);
        }
    }

    private static void dfs(int start, int sum) {
        for (int i = start; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                dfs(i + 1, sum + arr[i]);
                check[i] = false;
            }
        }

        if (sum == s) {
            cnt++;
            return;
        }
    }
}
