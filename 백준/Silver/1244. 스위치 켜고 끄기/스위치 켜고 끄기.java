import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int state = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (state == 1) {
                for (int j = num; j <= n; j+= num) {
                    click(j);
                }
            }

            if (state == 2) {
                int start = num;
                int l = 0;
                while ((start - l) >= 1 && (start + l) <= n) {
                    if (arr[start - l] == arr[start + l]) {
                        l++;
                    } else {
                        break;
                    }
                }

                for (int j = start - l + 1; j <= start + l - 1; j++) {
                    click(j);
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            sb.append(arr[k] + " ");
            if (k % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb.toString().trim());
    }

    private static void click(int order) {
        if (arr[order] == 1) {
            arr[order] = 0;
            return;
        }

        arr[order] = 1;
    }
}
