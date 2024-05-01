import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n + 1];
        String line = br.readLine();

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'P') {
                boolean eat = false;
                for (int j = k; j >= 1; j--) {
                    if (i - j >= 0 && line.charAt(i - j) == 'H' && check[i - j] == false) {
                        check[i - j] = true;
                        cnt++;
                        eat = true;
                        break;
                    }
                }

                if (!eat) {
                    for (int j = 1; j <= k; j++) {
                        if (i + j < n && line.charAt(i + j) == 'H' && check[i + j] == false) {
                            check[i + j] = true;
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}
