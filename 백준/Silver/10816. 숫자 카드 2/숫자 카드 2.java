import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> dict = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            dict.put(card, dict.getOrDefault(card, 0) + 1);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(dict.getOrDefault(number, 0)).append(" ");
        }

        System.out.print(sb);
    }
}
