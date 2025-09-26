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
            sum += (long) ((s.charAt(i) - 96) * Math.pow(31, i));
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
    }
}
