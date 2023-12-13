import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        System.out.print(getAnswer(line));
    }

    private static int getAnswer(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            sum += getEachTime(line.charAt(i));
        }
        return sum;
    }

    private static int getEachTime(char c) {
        if (65 <= c && c <= 67) {
            return 3;
        }

        if (68 <= c && c <= 70) {
            return 4;
        }

        if (71 <= c && c <= 73) {
            return 5;
        }

        if (74 <= c && c <= 76) {
            return 6;
        }

        if (77 <= c && c <= 79) {
            return 7;
        }

        if (80 <= c && c <= 83) {
            return 8;
        }

        if (84 <= c && c <= 86) {
            return 9;
        }

        if (87 <= c && c <= 90) {
            return 10;
        }
        return 11;
    }
}
