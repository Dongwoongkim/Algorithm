import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();

        Map<Integer, List<Integer>> frequency = new TreeMap<>();
        Map<Integer, Integer> fqMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);

            if (!fqMap.containsKey(num)) {
                fqMap.put(num, 1);
                continue;
            }

            fqMap.put(num, fqMap.get(num) + 1);
        }

        int maxCount = -1;

        maxCount = getMaxCount(arr, maxCount, frequency, fqMap);
        List<Integer> maxFrequencyNumbers = frequency.get(maxCount);

        sort(arr);
        sort(maxFrequencyNumbers);

        printAverage(arr);
        printMid(arr);
        printMode(maxFrequencyNumbers);
        printRange(arr);
    }

    private static int getMaxCount(List<Integer> arr, int maxCount,
                                   Map<Integer, List<Integer>> frequency,
                                   Map<Integer, Integer> fqMap) {
        Set<Integer> set = new HashSet<>(arr);
        for (Integer number : set) {

            int count = fqMap.get(number);

            if (maxCount <= count) {
                maxCount = count;
            }

            if (!frequency.containsKey(count)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(number);
                frequency.put(count, tmp);
                continue;
            }

            List<Integer> numbers = frequency.get(count);
            numbers.add(number);
            frequency.put(count, numbers);
        }

        return maxCount;
    }

    private static void printMid(List<Integer> arr) {
        System.out.println(arr.get(arr.size() / 2));
    }

    private static void printAverage(List<Integer> arr) {
        System.out.println(Math.round(arr.stream().mapToInt(Integer::intValue).average().getAsDouble()));
    }

    private static void printRange(List<Integer> arr) {
        System.out.println(arr.get(arr.size() - 1) - arr.get(0));
    }

    private static void printMode(List<Integer> maxFrequencyNumbers) {
        if (maxFrequencyNumbers.size() == 1) {
            System.out.println(maxFrequencyNumbers.get(0));
            return;
        }
        System.out.println(maxFrequencyNumbers.get(1));
    }
}
