import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.print(getGroupWord(line));
    }

    private static int getGroupWord(String line) {
        int word = 0;
        for (int i = 0; i < line.length(); i++) {
            if (i + 1 < line.length()) {
                if (line.charAt(i) == 'c' && (line.charAt(i + 1) == '=' || line.charAt(i + 1) == '-')) {
                    word++;
                    i++;
                    continue;
                }

                if (line.charAt(i) == 'd' && line.charAt(i + 1) == '-') {
                    word++;
                    i++;
                    continue;
                }

                if (line.charAt(i) == 'l' && line.charAt(i + 1) == 'j') {
                    word++;
                    i++;
                    continue;
                }

                if (line.charAt(i) == 'n' && line.charAt(i + 1) == 'j') {
                    word++;
                    i++;
                    continue;
                }

                if (line.charAt(i) == 's' && line.charAt(i + 1) == '=') {
                    word++;
                    i++;
                    continue;
                }

                if (line.charAt(i) == 'z' && line.charAt(i + 1) == '=') {
                    word++;
                    i++;
                    continue;
                }
            }

            if (i + 2 < line.length()) {
                if (line.charAt(i) == 'd' && line.charAt(i + 1) == 'z' && line.charAt(i + 2) == '=') {
                    word++;
                    i += 2;
                    continue;
                }
            }
            word++;
        }
        return word;
    }
}
