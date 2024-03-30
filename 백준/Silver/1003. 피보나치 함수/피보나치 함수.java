import java.util.Scanner;

public class Main {

    static int[] fibo = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();

            if (k == 0) {
                System.out.println("1 0");
                continue;
            }
            System.out.println(fibo[k - 1] + " " + fibo[k]);
        }
    }
}
