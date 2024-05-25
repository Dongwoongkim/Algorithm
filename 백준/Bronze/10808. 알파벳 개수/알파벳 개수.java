import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            arr[line.charAt(i) - '0' - 49]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
