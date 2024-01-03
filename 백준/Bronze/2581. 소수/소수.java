import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int sum = 0;
        int answer = -1;

        for (int i = m; i >= n; i--) {
            if (isPrime(i) && i != 1) {
                sum += i;
                answer = i;
            }
        }
        printAnswer(answer, sum);
    }

    private static void printAnswer(int answer, int sum) {
        if (answer == -1) {
            System.out.println(answer);
            return;
        }
        System.out.println(sum);
        System.out.println(answer);
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
