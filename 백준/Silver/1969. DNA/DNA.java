import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // A, T, G, C


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] count = new int[m + 1][4];

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(br.readLine());
        }

        String ans = "";
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr.get(i).charAt(j) == 'A') {
                    count[j][0]++;
                }
                if (arr.get(i).charAt(j) == 'C') {
                    count[j][1]++;
                }
                if (arr.get(i).charAt(j) == 'G') {
                    count[j][2]++;
                }
                if (arr.get(i).charAt(j) == 'T') {
                    count[j][3]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int k = 0;
            int idx = 0;
            for (int j = 0; j < 4; j++) {
                if (count[i][j] > k) {
                    idx = j;
                    k = count[i][j];
                }
            }
            if (idx == 0) {
                ans += 'A';
            }
            if (idx == 1) {
                ans += 'C';
            }
            if (idx == 2) {
                ans += 'G';
            }
            if (idx == 3) {
                ans += 'T';
            }

            cnt += n - k;
        }

        System.out.println(ans);
        System.out.println(cnt);
    }
}
