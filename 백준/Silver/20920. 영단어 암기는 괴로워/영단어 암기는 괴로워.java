import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<String> numbers = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        List<String> answer = new ArrayList<>();

        int n = Integer.parseInt(numbers.get(0));
        int m = Integer.parseInt(numbers.get(1));

        Map<String, Integer> dict = new TreeMap<>();
        Map<Integer, List<String>> frequency = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (word.length() < m) {
                continue;
            }

            if (!dict.containsKey(word)) {
                dict.put(word, 1);
                continue;
            }

            dict.put(word, dict.get(word) + 1);
        }

        for (String word : dict.keySet()) {
            if (!frequency.containsKey(dict.get(word))) {
                frequency.put(dict.get(word), new ArrayList<>());
            }
            List<String> strings = frequency.get(dict.get(word));
            strings.add(word);
            frequency.put(dict.get(word), strings);
        }

        Set<Integer> reversedSet = new TreeSet<>(frequency.keySet()).descendingSet();

        for (Integer f : reversedSet) {
            Collections.sort(frequency.get(f),
                    Comparator.comparing(String::length).reversed().thenComparing(Comparator.naturalOrder()));
            
            List<String> strings = frequency.get(f);
            for (String string : strings) {
                answer.add(string);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.print(sb);

    }
}
