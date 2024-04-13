import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> numbers = new ArrayList<>();
    static long l = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(line.charAt(i))));
        }

        Collections.sort(numbers);
        Collections.reverse(numbers);

        if (numbers.get(numbers.size() - 1) != 0) {
            System.out.println(-1);
            return;
        }

        String ans = "";
        for (Integer number : numbers) {
            ans += String.valueOf(number);
        }

        for (Integer number : numbers) {
            l += number;
        }

        if (l % 3 == 0) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
