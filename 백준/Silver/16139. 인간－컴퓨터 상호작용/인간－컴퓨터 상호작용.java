import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            List<String> line = Arrays.stream(br.readLine().split(" "))
                    .collect(Collectors.toList());

            String s = line.get(0);
            int start = Integer.parseInt(line.get(1));
            int end = Integer.parseInt(line.get(2));

            int count = 0;
            for (int j = start; j <= end; j++) {
                if (str.charAt(j) == s.charAt(0)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
