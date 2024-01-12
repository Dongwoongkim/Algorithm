import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(getCombination(n, m));
        }
    }

    private static BigInteger getCombination(int n, int m) {
        BigInteger bigN = BigInteger.valueOf(1);
        long k = n;

        for (int i = 0; i < m; i++) {
            bigN = bigN.multiply(BigInteger.valueOf(k));
            k--;
        }

        return bigN.divide(getFactorial(m));
    }

    private static BigInteger getFactorial(int n) {
        BigInteger result = BigInteger.valueOf(n);

        if (n == 0 || n == 1) {
            return BigInteger.valueOf(1);
        }

        return result.multiply(getFactorial(n - 1));
    }
}
