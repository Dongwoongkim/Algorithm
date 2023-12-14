import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> numberAndRadix = Arrays.stream(line.split(" ")).collect(Collectors.toList());

        String s = numberAndRadix.get(0);
        int radix = Integer.parseInt(numberAndRadix.get(1));

        long sum = 0;
        int x = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= 65) {
                sum += (c - 55) * x;
                x *= radix;
                continue;
            }
            sum += (long) Character.getNumericValue(c) * x;
            x *= radix;
        }

        System.out.print(sum);
    }
}
