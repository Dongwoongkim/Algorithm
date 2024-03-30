import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
            ans %= 1_000_000_000;

            while (true) {
                if (ans % 10 == 0) {
                    ans /= 10;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans % 10);
    }
}
