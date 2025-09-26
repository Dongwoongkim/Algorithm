import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;
    static int n;
    static long sum;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < n; i++) {
            long pow = 1;
            for (int j = 0; j < i; j++) {
                pow = (pow * 31) % 1234567891;
            }
            sum = (sum + ((s.charAt(i) - 96) * pow) % 1234567891) % 1234567891;
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
    }
}
