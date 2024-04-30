import java.io.IOException;
import java.util.Scanner;


public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] hansu = new boolean[1001];
        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                hansu[i] = true;
                continue;
            }

            if (i >= 100) {
                int first = i / 100;
                int second = i % 100 / 10;
                int third = i % 10;

                if (second * 2 == first + third) {
                    hansu[i] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (hansu[i] == true) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
