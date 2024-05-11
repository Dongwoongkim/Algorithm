import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static PriorityQueue<Graph> graphs = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        parent = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graphs.add(new Graph(from, to, cost));
        }

        int ans = 0;
        int cnt = 0;

        while (!graphs.isEmpty()) {
            if (cnt == v - 1) {
                break;
            }
            Graph graph = graphs.poll();

            int from = graph.from;
            int to = graph.to;

            if (!isSameParent(from, to)) {
                ans += graph.cost;
                union(from, to);
            }
        }

        System.out.println(ans);
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

    private static boolean isSameParent(int x, int y) {
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
        int cost;

        public Graph(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
