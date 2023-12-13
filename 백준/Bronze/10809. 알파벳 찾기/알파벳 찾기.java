import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        for (int i = 97; i < 123; i++) {
            System.out.print(line.indexOf(i) + " ");
        }
    }
}
