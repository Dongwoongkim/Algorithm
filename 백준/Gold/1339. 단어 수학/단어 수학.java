import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Character, Integer> map = new HashMap<>();
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = line.length() - 1; j >= 0; j--) {
                char c = line.charAt(line.length() - j - 1);

                if (map.get(c) == null) {
                    map.put(c, (int) Math.pow(10, j));
                } else if (map.get(c) != null) {
                    map.replace(c, map.get(c) + (int) Math.pow(10, j));
                }
            }
        }

        for (Character c : map.keySet()) {
            arr.add(map.get(c));
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        int sum = 0;
        int k = 9;
        for (Integer i : arr) {
            sum += i * k;
            k--;
        }

        System.out.println(sum);
    }
}

