import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<Integer>> vector = new ArrayList<>();
    static boolean[] check;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            vector.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            vector.get(start).add(end);
            vector.get(end).add(start);
        }

        dfs(1);

        System.out.print(ans);
    }

    private static void dfs(int node) {
        check[node] = true;

        if (node != 1) {
            ans++;
        }

        for (int next : vector.get(node)) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }
}
