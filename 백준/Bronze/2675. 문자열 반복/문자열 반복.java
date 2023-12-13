import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        for (int i = 0; i < Integer.parseInt(n); i++) {
            int repeat = sc.nextInt();
            String line = sc.nextLine().trim();

            for (int j = 0; j < line.length(); j++) {
                System.out.print(String.valueOf(line.charAt(j)).repeat(repeat));
            }
            System.out.println();
        }
    }
}
