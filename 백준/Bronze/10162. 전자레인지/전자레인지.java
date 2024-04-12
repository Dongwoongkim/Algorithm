import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;

        int a = n / 300;
        n %= 300;

        int b = n / 60;
        n %= 60;

        int c = n / 10;

        if (k == a * 300 + b * 60 + c * 10) {
            System.out.println(a + " " + b + " " + c);
        } else {
            System.out.println(-1);
        }
    }
}
