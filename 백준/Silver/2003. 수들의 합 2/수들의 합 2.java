import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            sum[i] += sum[i - 1] + arr[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == m) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
