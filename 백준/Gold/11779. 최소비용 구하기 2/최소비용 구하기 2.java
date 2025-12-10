import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<Node>> vectors = new ArrayList<>();
    static int[] dp;
    static int[] parent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            vectors.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            vectors.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dp[end]);

        Stack<Integer> path = new Stack<>();

        int next = end;
        while (next != -1) {
            path.add(next);
            if (next == start) {
                break;
            }
            next = parent[next];
        }

        if (path.get(path.size() - 1) != start) {
            System.out.println(0);
            System.out.println();
            return;
        }

        System.out.println(path.size());

        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }

    private static void dijkstra(int start) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.weight - b.weight
        );

        dp[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.num]) {
                continue;
            }
            visited[current.num] = true;

            for (Node nextNode : vectors.get(current.num)) {
                int next = nextNode.num;
                int cost = dp[current.num] + nextNode.weight;
                if (dp[next] > cost) {
                    dp[next] = cost;
                    parent[next] = current.num;
                    pq.add(new Node(next, dp[next]));
                }
            }
        }
    }

    static class Node {

        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
