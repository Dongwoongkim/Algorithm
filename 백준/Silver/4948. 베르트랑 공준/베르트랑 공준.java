import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
