import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer n = numbers.get(0);
        Integer m = numbers.get(1);

        Map<Integer, String> book1 = new HashMap<>();
        Map<String, Integer> book2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            book1.put(i, name);
            book2.put(name, i);
        }

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            if (isNumeric(line)) {
                System.out.println(book1.get(Integer.valueOf(line)));
                continue;
            }

            System.out.println(book2.get(line));
        }
    }

    private static boolean isNumeric(String line) {
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
