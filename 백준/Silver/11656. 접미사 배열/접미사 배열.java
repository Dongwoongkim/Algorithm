import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        List<String> dict = new ArrayList<>();

        for (int j = 0; j < line.length(); j++) {
            dict.add(line.substring(j, line.length()));
        }
        Collections.sort(dict);

        StringBuilder sb = new StringBuilder();
        for (String s : dict) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
