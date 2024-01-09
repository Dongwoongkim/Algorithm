import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(getAnswer(a, b));

    }

    private static long getAnswer(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
