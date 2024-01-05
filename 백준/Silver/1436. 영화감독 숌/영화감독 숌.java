import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long number = 1;
        int idx = 0;
        while (true) {
            number++;

            if (String.valueOf(number).contains("666")) {
                idx++;
            }

            if (idx == n) {
                System.out.print(number);
                break;
            }
        }
    }
}
