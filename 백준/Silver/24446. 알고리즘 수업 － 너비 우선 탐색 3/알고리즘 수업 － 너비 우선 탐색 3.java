import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check = new boolean[100001];
    static List<List<Integer>> v = new ArrayList<>(100001);
    static int[] ans = new int[100001];
    static int n, m, r;
    static int from, to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            v.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            v.get(from).add(to);
            v.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(v.get(i));
        }

        Arrays.fill(ans, -1);

        bfs(v, r);

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }

    }

    public static void bfs(List<List<Integer>> v, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        ans[start] = 0;
        check[start] = true;

        while (!q.isEmpty()) {
            int from = q.poll();

            for (int i = 0; i < v.get(from).size(); i++) {
                int depth = ans[from] + 1;
                int to = v.get(from).get(i);
                if (!check[to]) {
                    check[to] = true;
                    q.add(to);
                    ans[to] = depth;
                }
            }
        }
    }
}
