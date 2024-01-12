import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getCombination(n, m));
    }


    private static int getCombination(int n, int m) {
        int ans = 1;
        int k = n;

        for (int i = 0; i < m; i++) {
            ans *= k;
            k--;
        }

        return ans / getFactorial(m);
    }

    private static int getFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * getFactorial(n - 1);
    }
}
