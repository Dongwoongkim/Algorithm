import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < line.length(); i++) {
            map.put(line.charAt(i), map.getOrDefault(line.charAt(i), 0) + 1);
        }

        int maxFrequency = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        long count = map.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxFrequency))
                .count();

        printAnswer(maxFrequency, count, map);
    }

    private static void printAnswer(int maxFrequency, long count, Map<Character, Integer> map) {
        if (count >= 2) {
            System.out.print("?");
            return;
        }

        Character c = map.keySet().stream()
                .filter(key -> map.get(key).equals(maxFrequency))
                .findFirst().get();

        System.out.print(c);
    }
}
