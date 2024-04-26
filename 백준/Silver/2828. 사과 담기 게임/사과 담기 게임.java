import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int left = 1;
        int right = m;

        int appleCount = sc.nextInt();

        for (int i = 0; i < appleCount; i++) {
            int appleIndex = sc.nextInt();

            if (appleIndex >= left && appleIndex <= right) {
                continue;
            }

            if (appleIndex < left) {
                int move = left - appleIndex;
                ans += move;
                left = appleIndex;
                right = left + (m - 1);
                continue;
            }

            if (appleIndex > right) {
                int move = appleIndex - right;
                ans += move;
                right = appleIndex;
                left = right - (m - 1);
            }
        }

        System.out.println(ans);
    }
}
