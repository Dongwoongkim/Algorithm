import java.util.Scanner;

public class Main {

    static long p = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        // n이 정수, p가 소수일 때
        // ((n)!/(n-k)! * (k)!) % p = (n! % p) * (((n-k)! * (k)!)^(p-2)) % p) % p
        //                             ( a % p ) * ( c % p ) % p
        long a = getFactorial(n) % p;
        long b = getFactorial(n - k) % p;
        long c = getFactorial(k) % p;

        long d = getPow(b * c % p, p - 2) % p;

        System.out.println(a * d % p);
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

    private static long getFactorial(long number) {
        long ans = 1;

        while (true) {
            if (number == 0) {
                break;
            }
            ans = ans * number % p;
            number--;
        }
        return ans;
    }
}
