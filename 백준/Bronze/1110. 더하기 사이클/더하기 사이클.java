import java.util.Scanner;

public class Main {

    static int cnt = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int origin = sc.nextInt();

        int num = origin;
        while (true) {
            int s = num / 10;
            int k = num % 10;

            int r = k + s;
            if (k * 10 + r % 10 == origin) {
                break;
            }

            cnt++;
            num = k * 10 + r % 10;
        }
        System.out.println(cnt);
    }
}
