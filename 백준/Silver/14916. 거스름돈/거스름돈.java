import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] money = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 2 == 0) {
                money[i] = i / 5;
                continue;
            }

            if (i % 5 == 0) {
                money[i] = i / 5;
                continue;
            }

            if (i % 2 == 0) {
                money[i] = i / 2;
                continue;
            }
            
            money[i] = -1;
        }

        int ans = 100_001;
        for (int i = 0; i <= n; i++) {
            if (money[n - i] != -1 && money[i] != -1) {
                ans = Math.min(ans, money[n - i] + money[i]);
            }
        }

        if (ans == 100_001) {
            System.out.println(-1);
            return;
        }

        System.out.println(ans);
    }
}
