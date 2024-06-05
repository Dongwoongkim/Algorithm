import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int ans = a * b * c;

        int[] arr = new int[11];

        while (true) {
            if (ans == 0) {
                break;
            }
            arr[ans % 10]++;
            ans /= 10;
        }

        for (int i = 0; i <= 9; i++) {
            System.out.println(arr[i]);
        }
    }
}
