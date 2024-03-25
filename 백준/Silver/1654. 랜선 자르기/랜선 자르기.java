import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);
        System.out.println(getAnswer(arr, n, m));
    }

    private static long getAnswer(long[] arr, int n, int m) {
        long min = 0;
        long max = arr[n - 1] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += (arr[i]) / mid;
            }

            if (count < m) {
                max = mid;
            }

            if (count >= m) {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}
