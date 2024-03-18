import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[][] words = new int[28][200_001];

        words[str.charAt(0) - 97][0] = 1;

        int l = str.length();
        for (int i = 1; i < l; i++) {
            char c = str.charAt(i);
            for (int j = 0; j < 27; j++) {
                words[j][i] = words[j][i - 1];
            }
            words[c - 97][i] = words[c - 97][i - 1] + 1;
        }

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            char c = parts[0].charAt(0);
            int start = Integer.parseInt(parts[1]);
            int end = Integer.parseInt(parts[2]);

            if (start == 0) {
                sb.append(words[c - 97][end]).append("\n");
                continue;
            }

            sb.append(words[c - 97][end] - words[c - 97][start - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
