import java.util.Scanner;

public class Main {

    static boolean[] notPrime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        notPrime = new boolean[1_000_001];

        for (int i = 2; i <= 1_000_000; i++) {
            for (int j = i * 2; j <= 1_000_000; j += i) {
                notPrime[j] = true;
            }
        }

        while (true) {
            boolean flag = true;
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i = 3; i <= n; i++) {
                if (notPrime[i] == false && notPrime[n - i] == false) {
                    sb.append(n + " = " + i + " + " + (n - i)).append("\n");
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);
    }
}
