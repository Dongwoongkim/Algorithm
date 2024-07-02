import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] ans;
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        ans = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canSee(j, arr[j], i, arr[i])) {
                    ans[i]++;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (canSee(i, arr[i], j, arr[j])) {
                    ans[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            cnt = Math.max(ans[i], cnt);
        }
        System.out.println(cnt);
    }

    private static boolean canSee(int x1, int y1, int x2, int y2) {
        double gradient = (double) (y2 - y1) / (x2 - x1);

        for (int i = x1 + 1; i <= x2 - 1; i++) {
            if (f(i, x1, y1, gradient) <= (double) arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static double f(int x, int x1, int y1, double gradient) {
        return gradient * (x - x1) + y1;
    }
}
