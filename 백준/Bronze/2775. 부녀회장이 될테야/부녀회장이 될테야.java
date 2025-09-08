import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            output.append(getAnswer(k, n)).append("\n");
        }

        System.out.println(output);
    }

    private static int getAnswer(int k, int n) {
        if (k == 0) {
            return n;
        }

        if (n == 1) {
            return 1;
        }

        return getAnswer(k - 1, n) + getAnswer(k, n - 1);
    }
}