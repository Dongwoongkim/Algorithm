import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getAnswer(n));
    }

    private static Integer getAnswer(int n) {
        return (int) Math.pow(2, n);
    }
}
