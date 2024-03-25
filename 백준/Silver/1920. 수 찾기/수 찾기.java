import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int number = sc.nextInt();
            System.out.println(binarySearch(number, arr, n));
        }
    }

    private static int binarySearch(int number, int[] arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == number) {
                return 1;
            }

            if (number < arr[mid]) {
                end = mid - 1;
            }

            if (number > arr[mid]) {
                start = mid + 1;
            }
        }

        return 0;
    }
}
