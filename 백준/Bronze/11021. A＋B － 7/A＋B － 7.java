import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printAnswer(n, sc);
    }

    private static void printAnswer(int n, Scanner sc) {
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(String.format("Case #%d: %d", i, a + b));
        }
    }
}