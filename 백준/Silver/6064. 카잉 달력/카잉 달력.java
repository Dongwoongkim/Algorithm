import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(getAnswer(m, n, x - 1, y - 1)).append("\n");
        }

        System.out.println(sb);
    }

    private static int getAnswer(int m, int n, int x, int y) {
        // x값을 먼저 맞춘 상태에서 y값 탐색
        for (int i = x; i <= m * n; i += m) {
            if (i % n == y) {
                return i + 1;
            }
        }

        return -1;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
