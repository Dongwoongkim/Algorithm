import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int cur = arr[n - 1];
            long sum = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (cur < arr[i]) {
                    cur = arr[i];
                } else {
                    sum += cur - arr[i];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
