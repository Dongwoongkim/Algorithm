import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print(getFactorial(n));
    }

    private static long getFactorial(long n) {
        if (n == 1 || n == 0) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }
}
