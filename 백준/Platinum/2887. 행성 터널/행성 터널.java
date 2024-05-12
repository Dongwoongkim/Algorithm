import java.util.ArrayList;
import java.util.Collections;
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

        for (int i = 0; i < v; i++) {
            parent[i] = i;

            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            nodes.add(new Node(i, x, y, z));
        }

        Collections.sort(nodes, (node, o) -> Integer.compare(node.x, o.x));
        for (int i = 0; i < v - 1; i++) {
            int minCost = Math.abs(nodes.get(i).x - nodes.get(i + 1).x);
            graphs.add(new Graph(nodes.get(i).order, nodes.get(i + 1).order, minCost));
        }

        Collections.sort(nodes, (node, o) -> Integer.compare(node.y, o.y));
        for (int i = 0; i < v - 1; i++) {
            int minCost = Math.abs(nodes.get(i).y - nodes.get(i + 1).y);
            graphs.add(new Graph(nodes.get(i).order, nodes.get(i + 1).order, minCost));
        }

        Collections.sort(nodes, (node, o) -> Integer.compare(node.z, o.z));
        for (int i = 0; i < v - 1; i++) {
            int minCost = Math.abs(nodes.get(i).z - nodes.get(i + 1).z);
            graphs.add(new Graph(nodes.get(i).order, nodes.get(i + 1).order, minCost));
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


    static class Node {
        int order;
        int x;
        int y;
        int z;

        public Node(int order, int x, int y, int z) {
            this.order = order;
            this.x = x;
            this.y = y;
            this.z = z;
        }
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
