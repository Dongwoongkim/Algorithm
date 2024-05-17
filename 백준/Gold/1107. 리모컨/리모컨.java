import java.util.Scanner;

public class Main {

    static boolean[] disable = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            disable[sc.nextInt()] = true;
        }

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, Math.abs(n - 100));
//        System.out.println(ans);

        // 100 -> 0
        // 0,1고장
        // 2를 만들고 (1) +

        for (int i = 0; i <= 10_000_000; i++) {
            if (check(i)) {
                int length = String.valueOf(i).length();
                ans = Math.min(length + Math.abs(n - i), ans);
            }
        }

        System.out.println(ans);
    }

    private static boolean check(int number) {
        if (number == 0) {
            if (disable[0] == true) {
                return false;
            }
            return true;
        }

        while (true) {
            if (number == 0) {
                break;
            }
            if (disable[number % 10] == true) {
                return false;
            }
            number /= 10;
        }

        return true;
    }
}
