import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];

        int maxValue = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, map[i][j]);
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansH = -1;

        for (int i = 0; i <= 256; i++) {
            int tmp = b;
            int t = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] == i) {
                        continue;
                    }

                    // 제거해야함
                    if (map[j][k] > i) {
                        t += 2 * (map[j][k] - i);
                        tmp += (map[j][k] - i);
                        continue;
                    }

                    // 쌓아야함
                    if (map[j][k] < i) {
                        t += (i - map[j][k]);
                        tmp -= (i - map[j][k]);
                    }
                }
            }

            if (tmp >= 0) {
                if (t <= ansTime) {
                    ansTime = t;

                    if (i >= ansH) {
                        ansH = i;
                    }
                }
            }
        }

        System.out.println(ansTime + " " + ansH);
    }
}
