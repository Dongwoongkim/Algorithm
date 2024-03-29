import java.util.Scanner;

public class Main {

    static long p = 1_000_000_007;
    static long[] factorial = new long[4_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for (int i = 1; i <= 4_000_000; i++) {
            factorial[i] = ((factorial[i - 1] % p) * (i % p)) % p;
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            // n이 정수, p가 소수일 때
            // ((n)!/(n-k)! * (k)!) % p = (n! % p) * (((n-k)! * (k)!)^(p-2)) % p) % p
            //                             ( a % p ) * ( c % p ) % p
            long a = factorial[n];
            long b = factorial[n - k];
            long c = factorial[k];

            long d = getPow(b * c % p, p - 2) % p;

            sb.append(a * d % p).append("\n");
        }
        System.out.println(sb);
    }

    private static long getPow(long number, long exponent) {
        if (exponent == 1) {
            return number % p;
        }

        long half = getPow(number, exponent / 2);

        if (exponent % 2 == 1) {
            return (half * half % p) * (number) % p;
        }

        return half * half % p;
    }
}
