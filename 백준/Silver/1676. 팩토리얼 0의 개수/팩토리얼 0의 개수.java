import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                ans++;
            }
            if (i % 25 == 0) {
                ans++;
            }
            if (i % 125 == 0) {
                ans++;
            }
            if (i % 625 == 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
