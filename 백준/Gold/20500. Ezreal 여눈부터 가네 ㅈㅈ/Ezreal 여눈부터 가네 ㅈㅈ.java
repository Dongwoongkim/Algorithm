import java.util.Scanner;

public class Main {

    // 1자리 = 0개
    // 2자리 = 15 (1개)
    // 3자리 = 15 (1개)
    // 4자리 = 15, 1155, 1515, 5115 = 4개
    // 5자리 = 15, 1155, 1515, 5115(4개) + 11115 = 5개

    static long p = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(getAnswer(n));
    }

    private static long getAnswer(long n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n % 2 == 1) {
            return (2 * getAnswer(n - 1) - 1) % p;
        }

        return (2 * getAnswer(n - 1) + 1) % p;
    }
}
