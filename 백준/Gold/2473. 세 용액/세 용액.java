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

        long[] arr = new long[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 0, n);

        long first = 0;
        long second = 0;
        long third = 0;
        long gap = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[left] + arr[right] + arr[i];

                if (Math.abs(sum) < gap) {
                    gap = Math.abs(sum);
                    first = arr[i];
                    second = arr[left];
                    third = arr[right];
                }

                if (sum == 0) {
                    break;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }

        System.out.println(first + " " + second + " " + third);
    }
}
