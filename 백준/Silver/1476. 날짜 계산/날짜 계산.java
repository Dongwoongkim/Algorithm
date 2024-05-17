import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getAnswer(e, s, m));
    }

    private static int getAnswer(int e, int s, int m) {
        int cnt = 1;

        int a = 1;
        int b = 1;
        int c = 1;

        while (true) {
            if (a == e && b == s && c == m) {
                return cnt;
            }

            a++;
            b++;
            c++;

            if (a == 16) {
                a = 1;
            }
            if (b == 29) {
                b = 1;
            }
            if (c == 20) {
                c = 1;
            }
            cnt++;
        }
    }
}
