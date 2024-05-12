import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        List<Node> nodes = new ArrayList<>();
        PriorityQueue<Graph> graphs = new PriorityQueue<>();

        parent = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }

        int order = 0;
        for (int i = 0; i < v; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            nodes.add(new Node(order++, x, y));
        }

        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                Node from = nodes.get(i);
                Node to = nodes.get(j);

                double xD = Math.abs(from.x - to.x);
                double yD = Math.abs(from.y - to.y);

                double cost = Math.sqrt(xD * xD + yD * yD);
                graphs.add(new Graph(i, j, cost));
            }
        }

        double ans = 0;
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

        System.out.printf("%.2f", ans);
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


    static class Node {
        int order;
        double x;
        double y;

        public Node(int order, double x, double y) {
            this.order = order;
            this.x = x;
            this.y = y;
        }
    }

    static class Graph implements Comparable<Graph> {
        int from;
        int to;
        double cost;

        public Graph(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}
