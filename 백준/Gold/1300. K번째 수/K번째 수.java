import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long left = 1;
        long right = k;

        // B[k] = T => T보다 작거나 같은 원소가 k개
        // 1 <= T <= k ( T의 최댓값은 k)
        while (left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (long i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if (k <= cnt) {
                right = mid;
            }

            if (k > cnt) {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
