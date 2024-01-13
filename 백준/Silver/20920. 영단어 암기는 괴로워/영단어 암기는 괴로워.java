import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> numbers = Arrays.asList(br.readLine().split(" "));
        int n = Integer.parseInt(numbers.get(0));
        int m = Integer.parseInt(numbers.get(1));

        Map<String, Integer> dict = new TreeMap<>();
        Map<Integer, List<String>> frequency = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() >= m) {
                dict.put(word, dict.getOrDefault(word, 0) + 1);
            }
        }

        List<String> answer = new ArrayList<>();

        dict.forEach((word, count) ->
                frequency.computeIfAbsent(count, k -> new ArrayList<>()).add(word));

        frequency.forEach((count, words) ->
                Collections.sort(words,
                        Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder())));

        frequency.values().forEach(answer::addAll);

        answer.forEach(str -> sb.append(str).append("\n"));

        System.out.print(sb);
    }
}
