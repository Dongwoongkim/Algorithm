import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int ans = -1;

            Map<Integer, String> map = new HashMap<>();

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                String line = st.nextToken();
                map.put(c, line);
                ans = Math.max(ans, c);
            }
            System.out.println(map.get(ans));
        }
    }
}
