import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> history = new HashSet<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line.equals("ENTER")) {
                history.clear();
                continue;
            }

            if (!history.contains(line) && !line.equals("ENTER")) {
                history.add(line);
                ans++;
            }
        }

        System.out.println(ans);
    }
}
