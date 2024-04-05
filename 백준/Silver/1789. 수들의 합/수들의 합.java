import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long num = 1;
        while (true) {
            long sum = num * (num + 1) / 2;

            if (sum > n) {
                System.out.println(num - 1);
                break;
            }

            num++;
        }
    }
}
