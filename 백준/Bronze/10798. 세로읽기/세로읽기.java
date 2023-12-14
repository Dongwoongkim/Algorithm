import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> a = new ArrayList<>();

        int maxLength = 0;
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();
            a.add(line);

            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                String line = a.get(j);
                if (line.length() > i) {
                    System.out.print(line.charAt(i));
                }
            }
        }
    }
}
