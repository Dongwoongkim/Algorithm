import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        boolean[] prime = new boolean[1_000_001];
        checkPrime(prime);

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int cnt = getAnswer(n, prime);
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static int getAnswer(int n, boolean[] prime) {
        int cnt = 0;
        for (int j = 2; j <= n / 2; j++) {
            int tmp = n - j;
            if (prime[j] == false && prime[tmp] == false) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void checkPrime(boolean[] prime) {
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1_000_000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
