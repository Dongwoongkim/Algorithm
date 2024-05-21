import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] friends = new boolean[4001][4001];
    static int[] count = new int[4001];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = true;
            friends[b][a] = true;

            count[a]++;
            count[b]++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (friends[i][j] == true) {
                    for (int k = j + 1; k <= n; k++) {
                        if (friends[i][k] && friends[j][k]) {
                            int sum = count[i] + count[j] + count[k] - 6;
//                            System.out.println(i + " " + j + " " + k + " " + sum);
                            ans = Math.min(ans, sum);
                        }
                    }
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}
