import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String ans = "";
        String ucpc = "UCPC";
        int idx = 0;
        for (int i = 0; i < line.length(); i++) {
            if (idx < ucpc.length() && line.charAt(i) == ucpc.charAt(idx)) {
                ans += line.charAt(i);
                idx++;
            }
        }

        if (ans.equals(ucpc)) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
