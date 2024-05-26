import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] sequence = new char[n + 1];
        for (int i = 0; i < n; i++) {
            sequence[i] = Character.valueOf(st.nextToken().charAt(0));
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sequence[i] == '1') {
                sequence[i] = '0';

                if (i + 1 < n) {
                    if (sequence[i + 1] == '0') {
                        sequence[i + 1] = '1';
                    } else if (sequence[i + 1] == '1') {
                        sequence[i + 1] = '0';
                    }
                }

                if (i + 2 < n) {
                    if (sequence[i + 2] == '0') {
                        sequence[i + 2] = '1';
                    } else if (sequence[i + 2] == '1') {
                        sequence[i + 2] = '0';
                    }
                }
                
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
