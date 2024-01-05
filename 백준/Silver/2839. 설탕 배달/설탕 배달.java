import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printAnswer(n);
    }

    private static void printAnswer(int n) {
        int sum = 0;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                sum = 3 * i + 5 * j;
                if (5 * j > n) {
                    break;
                }
                if (sum == n) {
                    System.out.println(i + j);
                    return;
                }
            }

            if (3 * i > n) {
                break;
            }
        }

        System.out.println(-1);
    }
}
