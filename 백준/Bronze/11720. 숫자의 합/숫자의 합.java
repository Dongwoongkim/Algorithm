import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String line = sc.nextLine();
        int sum = 0;

        for (int i = 0; i < Integer.parseInt(n); i++) {
            sum += Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        System.out.print(sum);
    }
}
