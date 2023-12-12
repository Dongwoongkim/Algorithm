import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(answer(a, b));
    }

    private static String answer(int a, int b) {
        if (a > b) {
            return ">";
        }
        if (a < b) {
            return "<";
        }
        return "==";
    }
}
