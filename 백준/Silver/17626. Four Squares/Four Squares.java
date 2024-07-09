import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];

        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i - j * j] + 1, arr[i]);
            }
        }

        System.out.println(arr[n]);
    }
}

