import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[9];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = 0;
        if (arr[1] > arr[0]) {
            k = 1;
        } else {
            k = -1;
        }

        for (int i = 2; i < 8; i++) {
            if (arr[i] > arr[i - 1] && k == 1) {
                continue;
            }

            if (arr[i] < arr[i - 1] && k == -1) {
                continue;
            }

            if (arr[i] < arr[i - 1] && k == 1) {
                System.out.println("mixed");
                return;
            }

            if (arr[i] > arr[i - 1] && k == -1) {
                System.out.println("mixed");
                return;
            }
        }

        if (k == 1) {
            System.out.println("ascending");
            return;
        }

        System.out.println("descending");
    }
}
