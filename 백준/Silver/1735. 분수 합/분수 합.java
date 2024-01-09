import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int mother = b * d / gcd(b, d);
        int son = a * (mother / b) + c * (mother / d);

        int k = gcd(son, mother);
        System.out.println(son / k + " " + mother / k);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
