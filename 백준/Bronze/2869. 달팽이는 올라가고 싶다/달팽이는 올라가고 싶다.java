import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int day = ((c - a) / (a - b)) + 1;

        if ((a - b) * (day - 1) < c - a) {
            day++;
        }
        System.out.print(day);
    }
}
