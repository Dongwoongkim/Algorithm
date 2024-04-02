import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int ans = 1_000_000 * 11;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }

        for (int start = 0; start < n; start++) {
            boolean[] check = new boolean[n + 1];
            dfs(start, start, 0, 0, check);
        }
        System.out.println(ans);
    }

    private static void dfs(int start, int now, int depth, int sum, boolean[] check) {
        check[start] = true;

        if (depth == n - 1) {
            if (graph.get(now).get(start) != 0) {
                ans = Math.min(ans, sum + graph.get(now).get(start));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i != now && check[i] == false) {
                int next = i;
                if (graph.get(now).get(next) != 0) {
                    check[next] = true;
                    dfs(start, next, depth + 1, sum + graph.get(now).get(next), check);
                    check[next] = false;
                }
            }
        }
    }
}
