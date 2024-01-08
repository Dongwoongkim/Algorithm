import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.print(getAnswer(line));
    }

    private static Integer getAnswer(String line) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < line.length(); i++) {
            for (int j = i + 1; j <= line.length(); j++) {
                if (i < line.length()) {
                    set.add(line.substring(i, j));
                }
            }
        }
        return set.size();
    }
}
