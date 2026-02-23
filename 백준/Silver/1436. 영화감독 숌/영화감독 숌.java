import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int num = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (cnt == n) {
                System.out.print(num);
                break;
            }
            num++;
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
        }
    }
}