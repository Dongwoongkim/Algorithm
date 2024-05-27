import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String line = br.readLine();

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (line.charAt(i) == 'I') {
                int cnt = 0;

                while (true) {
                    if (i + 2 < m && line.charAt(i + 1) == 'O' && line.charAt(i + 2) == 'I') {
                        cnt++;
                        i += 2;
                    } else {
                        break;
                    }

                    if (cnt == n) {
                        cnt--;
                        ans++;
                    }
                }

            }
        }

        System.out.println(ans);
    }
}
