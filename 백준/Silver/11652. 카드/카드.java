import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        int max = -1;
        long num = 0;
        for (long l : map.keySet()) {
            if (map.get(l) > max) {
                max = map.get(l);
                num = l;
            } else if (map.get(l) == max) {
                num = Math.min(l, num);
            }
        }
        System.out.println(num);
    }
}
