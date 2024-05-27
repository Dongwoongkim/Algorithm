import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String l = "I";

        for (int i = 0; i < n; i++) {
            l += "OI";
        }

        String line = br.readLine();
        int cnt = 0;

        int idx = 0;
        while (true) {
            if (idx > m - l.length()) {
                break;
            }
            if (line.substring(idx, idx + l.length()).equals(l)) {
                cnt++;
            }
            
            idx++;
        }
        System.out.println(cnt);
    }
}
