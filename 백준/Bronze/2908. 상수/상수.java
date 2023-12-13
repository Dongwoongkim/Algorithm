import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> numbers = Arrays.stream(line.split(" ")).collect(Collectors.toList());

        String a = "";
        String b = "";

        String s = numbers.get(0);
        String s2 = numbers.get(1);

        for (int i = s.length() - 1; i >= 0; i--) {
            a += s.charAt(i);
        }

        for (int i = s2.length() - 1; i >= 0; i--) {
            b += s2.charAt(i);
        }

        System.out.println(Math.max(Integer.parseInt(a), Integer.parseInt(b)));

    }
}
