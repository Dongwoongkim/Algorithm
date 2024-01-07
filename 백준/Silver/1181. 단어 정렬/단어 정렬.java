import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, List<String>> words = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            List<String> list = words.get(word.length());

            if (list == null) {
                List<String> values = new ArrayList<>();
                values.add(word);
                words.put(word.length(), values);
                continue;
            }

            if (!list.contains(word)) {
                list.add(word);
                words.put(word.length(), list);
            }
        }

        List<Integer> lengths = words.keySet()
            .stream()
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        sort(lengths);

        for (Integer length : lengths) {
            List<String> values = words.get(length);
            sort(values);
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}
