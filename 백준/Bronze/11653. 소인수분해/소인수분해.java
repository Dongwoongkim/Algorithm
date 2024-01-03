import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printAnswer(n);
    }

    private static void printAnswer(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }
    }
}
