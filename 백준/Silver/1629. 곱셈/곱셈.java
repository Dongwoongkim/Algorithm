import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(pow(a, b, c));
    }

    private static long pow(long a, long exponent, long c) {
        if (exponent == 1) {
            return a % c;
        }
        long left = pow(a, exponent / 2, c);

        if (exponent % 2 == 1) {
            return ((left * left % c) * a) % c;
        }

        return (left * left) % c;
    }
}
