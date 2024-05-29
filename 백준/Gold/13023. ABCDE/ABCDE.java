import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean flag = false;
    static List<List<Integer>> friends = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (!flag) {
                check = new boolean[n + 1];
                check[i] = true;
                dfs(i, 1);
            }
        }

        System.out.println(flag == true ? 1 : 0);
    }

    private static void dfs(int cur, int cnt) {
        if (cnt == 5) {
            flag = true;
            return;
        }

        List<Integer> frds = friends.get(cur);

        for (Integer i : frds) {
            if (check[i] == false) {
                check[i] = true;
                dfs(i, cnt + 1);
                check[i] = false;
            }
        }
    }
}
