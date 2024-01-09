import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean[] prime = new boolean[b + 1];

        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= b; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = a; i <= b; i++) {
            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
