import java.util.Scanner;

public class Main {

    static long arr[];
    static long sum[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new long[n + 1];
        sum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }

        sum[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            sum[i] += arr[i] + sum[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == b) {
                sb.append(arr[b]).append("\n");
                continue;
            }
            sb.append(sum[b] - sum[a] + arr[a]).append("\n");
        }

        System.out.println(sb);
    }
}
