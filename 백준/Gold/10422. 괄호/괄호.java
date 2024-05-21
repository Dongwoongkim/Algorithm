import java.util.Scanner;

public class Main {

    static long[] arr = new long[5001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr[0] = 1;
        arr[2] = 1;

        for (int i = 4; i <= 5000; i++) {
            if (i % 2 == 0) {
                for (int j = i; j >= 2; j -= 2) {
                    arr[i] += arr[j - 2] * arr[i - j];
                    arr[i] %= 1_000_000_007;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(arr[num]);
        }
    }
}
