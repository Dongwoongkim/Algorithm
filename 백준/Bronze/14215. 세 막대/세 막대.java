import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        extracted(a, b, c);
    }

    private static void extracted(int a, int b, int c) {
        for (int i = a; i >= 1; i--) {
            for (int j = b; j >= 1; j--) {
                for (int k = c; k >= 1; k--) {
                    Integer answer = getAnswer(i, j, k);
                    if (answer != 0) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }
    }

    private static Integer getAnswer(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int sum = a + b + c;

        if (max < sum - max) {
            return sum;
        }

        return 0;
    }
}
