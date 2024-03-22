import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cost = new long[n];
        long[] gas = new long[n + 1];

        for (int i = 0; i < n - 1; i++) {
            cost[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            if (gas[i - 1] < gas[i]) {
                gas[i] = gas[i - 1];
            }
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += gas[i] * cost[i];
        }

        System.out.println(ans);

    }
}
