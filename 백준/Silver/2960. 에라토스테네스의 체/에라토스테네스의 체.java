import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;

    static boolean[] remove = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int order = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!remove[j]) {
                    remove[j] = true;
                    order++;
                }
                if (order == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}