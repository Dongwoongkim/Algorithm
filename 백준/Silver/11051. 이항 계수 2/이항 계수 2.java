import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] pascal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        pascal = new long[1001][1001];

        pascal[1][1] = 1;
        pascal[2][1] = 2;
        pascal[2][2] = 1;

        for (int i = 1; i <= n; i++) {
            pascal[i][1] = i;
            pascal[i][0] = 1;
            pascal[i][i] = 1;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % 10007;
            }
        }

        System.out.println(pascal[n][k] % 10007);
    }
}
