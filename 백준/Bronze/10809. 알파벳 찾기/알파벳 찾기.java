import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 97; i < 123; i++) {
            System.out.print(s.indexOf(i) + " ");
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }
}
