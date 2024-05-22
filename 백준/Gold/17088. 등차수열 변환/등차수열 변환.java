import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 수에 연산을 최대 한번만 적용할 수 있으니까 총 9(3*3)가지 공차가 나옴.
        // 1) 첫째항 = 첫째항 -1, 첫째항, 첫째항 + 1
        // 2) 둘째항 = 둘째항 -1, 둘째항, 둘째항 + 1

        for (int i = -1; i <= 1; i++) {
            int first = arr[0] + i;

            for (int j = -1; j <= 1; j++) {
                int second = arr[1] + j;
                int diff = second - first;

                int count = 0;
                if (first != arr[0]) {
                    count++;
                }

                if (second != arr[1]) {
                    count++;
                }

                boolean flag = true;

                for (int k = 2; k < n; k++) {
                    if (Math.abs(first + (k) * diff - arr[k]) > 1) {
                        flag = false;
                        break;
                    }
                    if (Math.abs(first + (k) * diff - arr[k]) == 1) {
                        count++;
                    }
                }

                if (flag) {
                    ans = Math.min(ans, count);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
