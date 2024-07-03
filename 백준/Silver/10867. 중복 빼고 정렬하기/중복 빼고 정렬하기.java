import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[1001];
    static int[] arr2 = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                arr[num]++;
            }
            if (num < 0) {
                arr2[-1 * num]++;
            }
        }

        for (int i = 1000; i >= 1; i--) {
            if (arr2[i] != 0) {
                sb.append(i * -1 + " ");
            }
        }

        for (int i = 0; i <= 1000; i++) {
            if (arr[i] != 0) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
