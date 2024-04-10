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

        int ans = arr[n - 1];

        int cnt = 2;
        for (int i = n - 2; i >= 0; i--) {
            int tmp = arr[i] * cnt;
            cnt++;

            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);

    }
}
