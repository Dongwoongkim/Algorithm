import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        int start = (n / 100) * 100;

        while (true) {
            if (start % f == 0) {
                int ans = start % 100;
                if (String.valueOf(ans).length() == 1) {
                    System.out.print(0);
                }
                System.out.println(ans);
                break;
            }
            start++;
        }
    }
}
