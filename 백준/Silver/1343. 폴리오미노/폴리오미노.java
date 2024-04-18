import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String s = line.replaceAll("XXXX", "AAAA");
        String ans = s.replaceAll("XX", "BB");

        if (ans.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
