import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        printAnswer(n, sc, x);
    }

    private static void printAnswer(int n, Scanner sc, int x) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum += (a * b);
        }

        if (sum == x) {
            System.out.print("Yes");
            return;
        }
        System.out.print("No");
    }
}

