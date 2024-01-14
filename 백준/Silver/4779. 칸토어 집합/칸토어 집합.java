import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(input);
            cut(n, (int) Math.pow(3, n - 1), sb);
            System.out.println(sb);
        }
    }

    private static void cut(int n, int emptySpaceSize, StringBuilder sb) {
        if (n == 0) {
            sb.append("-");
            return;
        }

        cut(n - 1, (int) Math.pow(3, n - 2), sb);
        for (int i = 0; i < emptySpaceSize; i++) {
            sb.append(" ");
        }
        cut(n - 1, (int) Math.pow(3, n - 2), sb);
    }
}
