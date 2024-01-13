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
        Map<String, Boolean> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            List<String> people = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());

            if (people.get(0).equals("ChongChong") || people.get(1).equals("ChongChong")) {
                map.put(people.get(0), true);
                map.put(people.get(1), true);
                continue;
            }

            if (map.containsKey(people.get(0)) && map.get(people.get(0))) {
                map.put(people.get(1), true);
            }

            if (map.containsKey(people.get(1)) && map.get(people.get(1))) {
                map.put(people.get(0), true);
            }
        }

        System.out.println(map.size());
    }
}
