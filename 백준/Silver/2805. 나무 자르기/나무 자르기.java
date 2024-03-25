import java.util.Scanner;

public class Main {

    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n + 1];

        long max = -1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        System.out.println(getAnswer(arr, n, m, max));
    }

    private static long getAnswer(long[] arr, int n, int m, long max) {
        long min = 0;

        while (min < max) {
            long mid = (min + max) / 2;

            long count = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] >= mid) {
                    count += (arr[i] - mid);
                }
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
