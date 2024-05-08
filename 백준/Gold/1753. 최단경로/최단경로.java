import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int start;
    static boolean[] visited;
    static int[] distance;
    static int[][] cost;
    static List<List<Node>> vector = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            vector.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int value = sc.nextInt();
            vector.get(x).add(new Node(y, value));
        }

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(distance[i]);
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.to] = true;

            int next = cur.to;

            List<Node> nodes = vector.get(next);

            // 시작 노드에 연결된 노드들 검사하여 최소비용 갱신
            for (Node node : nodes) {
                if (visited[node.to] == false) {
                    if (distance[cur.to] + node.value < distance[node.to]) {
                        distance[node.to] = distance[cur.to] + node.value;
                        q.add(new Node(node.to, distance[node.to]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int value;

        public Node(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
