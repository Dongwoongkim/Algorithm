import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int a1 = Math.abs(w - x);
        int a2 = Math.abs(h - y);
        int a3 = Math.abs(y);
        int a4 = Math.abs(x);

        System.out.println(Math.min(a1, Math.min(a2, Math.min(a3, a4))));
    }
}
