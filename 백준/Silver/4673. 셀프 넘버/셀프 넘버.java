import java.util.Scanner;

public class Main {

    static int[] selfNumber = new int[99999];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10000; i++) {
            int number = i;

            int sum = 0;
            while (true) {
                if (number == 0) {
                    break;
                }
                sum += number % 10;
                number /= 10;
            }
            selfNumber[i + sum]++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (selfNumber[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
