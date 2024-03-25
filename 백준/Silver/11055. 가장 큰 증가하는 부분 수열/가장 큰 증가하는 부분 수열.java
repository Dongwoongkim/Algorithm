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
            ans[i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    ans[j] = Math.max(ans[i] + arr[j], ans[j]);
                }
            }
        }

        int k = -1;
        for (int i = 0; i < n; i++) {
            k = Math.max(ans[i], k);
        }
        System.out.println(k);
    }
}
