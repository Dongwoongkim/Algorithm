import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.print(getAnswer(line));
    }

    private static int getAnswer(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != line.charAt(line.length() - (i + 1))) {
                return 0;
            }
        }
        return 1;
    }
}
