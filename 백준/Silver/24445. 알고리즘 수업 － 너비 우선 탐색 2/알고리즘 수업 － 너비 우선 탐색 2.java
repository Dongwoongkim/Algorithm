import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int cnt = 1;
    static int[] ans = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
            Collections.reverse(graph.get(i));
        }

        bfs(start, graph);

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    private static void bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        ans[start] = cnt++;
        visited[start] = true;

        while (!q.isEmpty()) {
            int from = q.peek();
            q.remove();

            for (int i = 0; i < graph.get(from).size(); i++) {
                int to = graph.get(from).get(i);
                if (visited[to] == false) {
                    visited[to] = true;
                    ans[to] = cnt++;
                    q.add(to);
                }
            }
        }
    }
}
