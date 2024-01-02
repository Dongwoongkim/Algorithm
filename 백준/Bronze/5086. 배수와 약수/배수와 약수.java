import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            System.out.println(getAnswer(n, m));

        }

    }

    private static String getAnswer(int n, int m) {
        if (m % n == 0) {
            return "factor";
        }

        if (n % m == 0) {
            return "multiple";
        }

        return "neither";
    }
}
