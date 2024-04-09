import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static List<Character> moeum = new ArrayList<>();
    static List<Character> jaeum = new ArrayList<>();
    static List<Character> password = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = st.nextToken();
            char c = s.charAt(0);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moeum.add(c);
            } else {
                jaeum.add(c);
            }

            password.add(c);
        }

        Collections.sort(password);
        char[] tmp = new char[n + 1];
        boolean[] check = new boolean[m + 1];

        dfs(0, 0, tmp, check);
    }

    private static void dfs(int pos, int start, char[] tmp, boolean[] check) {
        if (pos == n) {
            int moeumCnt = 0;
            int jaeumCnt = 0;
            for (int i = 0; i < n; i++) {
                if (moeum.contains(tmp[i])) {
                    moeumCnt++;
                }

                if (jaeum.contains(tmp[i])) {
                    jaeumCnt++;
                }
            }

            if (moeumCnt >= 1 && jaeumCnt >= 2) {
                for (int i = 0; i < n; i++) {
                    System.out.print(tmp[i]);
                }
                System.out.println();
            }

            return;
        }

        for (int i = start; i < m; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[pos] = password.get(i);
                dfs(pos + 1, i + 1, tmp, check);
                check[i] = false;
            }
        }
    }
}
