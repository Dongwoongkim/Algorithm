import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();

            while (true) {
                if (isPrime(n)) {
                    break;
                }
                n++;
            }
            sb.append(n).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
