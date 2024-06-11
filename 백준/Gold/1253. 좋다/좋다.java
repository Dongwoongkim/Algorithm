import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long findNum = arr[i];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                long sum = arr[left] + arr[right];
                if (sum == findNum) {
                    if (left != i && right != i) {
                        ans++;
                        break;
                    }
                    if (left == i) {
                        left++;
                    }
                    if (right == i) {
                        right--;
                    }
                }

                if (sum < findNum) {
                    left++;
                } else if (sum > findNum) {
                    right--;
                }
            }
        }

        System.out.println(ans);
    }
}
