import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp = new int[2001][2001];
    static int[] arr = new int[2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 한 글자인 경우 펠린
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        // 두 글자인 경우 두 문자가 같다면 펠린
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int gap = 2; gap <= n - 1; gap++) {
            for (int j = 1; j <= n - gap; j++) {
//                System.out.println((j) + " " + (j + gap));
                // 양쪽 끝의 원소가 같고 && (처음 + 1) ~ (끝 - 1)이 같을 때
                if (arr[j] == arr[j + gap]) {
                    if (dp[j + 1][j + gap - 1] == 1) {
                        dp[j][j + gap] = 1;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[start][end]).append("\n");
        }
        System.out.print(sb);
    }
}
