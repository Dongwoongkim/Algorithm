import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(getPrizeMoney(a, b, c));
    }

    private static int getPrizeMoney(int a, int b, int c) {
        if ((a == b) && (b == c)) {
            return 10000 + a * 1000;
        }
        
        if ((a != b) && (b != c) && (a != c)) {
            return 100 * Math.max(a, Math.max(b, c));
        }
        
        if ((a == b && b != c) || (a == c && c != b)) {
            return 1000 + a * 100;
        }
        
        if ((b == c && c != a) || (b == a && a != c)) {
            return 1000 + b * 100;
        }
        
        if ((c == a && a != b) || (c == b && b != a)) {
            return 1000 + c * 100;
        }

        return 0;
    }
}

