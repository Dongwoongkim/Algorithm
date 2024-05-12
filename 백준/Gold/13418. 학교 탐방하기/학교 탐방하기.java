import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        List<Graph> graphs = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int k = sc.nextInt();

            graphs.add(new Graph(from, to, k));
        }

        int cnt = 0;
        int worst = 0;
        int best = 0;

        Collections.sort(graphs, (graph, o) -> Integer.compare(o.k, graph.k));
        for (int i = 0; i < m; i++) {
            if (cnt == n) {
                break;
            }

            Graph graph = graphs.get(i);
            if (!isParentSame(graph.from, graph.to)) {
                union(graph.from, graph.to);
                cnt++;
                if (graph.k == 0) {
                    best++;
                }
            }
        }

        Collections.reverse(graphs);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        cnt = 0;

        for (int i = 0; i < m; i++) {
            if (cnt == n) {
                break;
            }

            Graph graph = graphs.get(i);
            if (!isParentSame(graph.from, graph.to)) {
                union(graph.from, graph.to);
                cnt++;
                if (graph.k == 0) {
                    worst++;
                }
            }
        }

        System.out.println(worst * worst - best * best);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
            return;
        }

        parent[x] = y;
    }

    private static boolean isParentSame(int x, int y) {
        x = find(x);
        y = find(y);

        return parent[x] == parent[y];
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    static class Graph implements Comparable<Graph> {

        int from;
        int to;
        int k;

        public Graph(int from, int to, int k) {
            this.from = from;
            this.to = to;
            this.k = k;
        }

        @Override
        public int compareTo(Graph o) {
            return Integer.compare(o.k, this.k);
        }
    }
}
