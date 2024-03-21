import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] arr = new long[n + 1];
        long[] c_sum = new long[n + 1];
        long[] cnt = new long[m];
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        c_sum[1] = arr[1] % m;

        for (int i = 2; i <= n; i++) {
            c_sum[i] = (arr[i] + c_sum[i - 1]) % m;
        }

        for (int start = 1; start <= n; start++) {
            if (c_sum[start] == 0) {
                ans++;
            }

            long l = c_sum[start];
            cnt[(int) l]++;
        }

        for (int i = 0; i < m; i++) {
            if (cnt[i] > 1) {
                ans += (cnt[i] * (cnt[i] - 1)) / 2;
            }
        }

        System.out.println(ans);
    }
}
