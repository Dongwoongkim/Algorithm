import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        int left = 0;
        int right = n - 1;
        int gap = Integer.MAX_VALUE;

        int f = 0;
        int s = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < gap) {
                gap = Math.abs(sum);
                f = arr[left];
                s = arr[right];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            }
        }

        System.out.println(f + " " + s);
    }
}
