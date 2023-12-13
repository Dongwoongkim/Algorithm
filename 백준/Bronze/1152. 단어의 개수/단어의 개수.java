import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        printAnswer(line);
    }

    private static void printAnswer(String line) {
        if (line.isEmpty()) {
            System.out.print(0);
            return;
        }
        System.out.print(Arrays.stream(line.split(" ")).count());
    }
}
