import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int cnt = 1;

        for (int i = 0; i < line.length(); i++) {
            for (int j = i + 1; j < line.length(); j++) {
                if (line.charAt(i) != line.charAt(j)) {
                    cnt++;
                    i = j - 1;
                    break;
                }
            }
        }

        System.out.println(cnt / 2);
    }
}
