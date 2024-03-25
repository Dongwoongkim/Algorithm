import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);

        System.out.println(binarySearch(arr));
    }

    private static int binarySearch(int[] arr) {
        int start = 1;
        int end = arr[n - 1] + 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int count = installCount(mid);

            if (count >= c) {
                start = mid + 1;
            }
            if (count < c) {
                end = mid;
            }
        }

        return start - 1;
    }

    private static int installCount(int interval) {
        int count = 1;
        int start = arr[0];

        for (int i = 1; i < n; i++) {
            int next = arr[i];
            if (next - start >= interval) {
                count++;
                start = arr[i];
            }
        }

        return count;
    }
}
