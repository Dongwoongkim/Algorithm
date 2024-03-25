import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n + 1];
        ans = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sc.nextInt();
        }
        Arrays.sort(arr, 0, n);
        Arrays.sort(ans, 0, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * ans[n - 1 - i];
        }
        System.out.println(sum);
    }
}
