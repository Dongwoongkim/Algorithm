import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] distance = new int[100_001];
    static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= m; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstra(n);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;
        visited[start] = true;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int next = curNode.next;
            int cost = curNode.value;

            visited[next] = true;
            if (next == m) {
                System.out.println(cost);
                break;
            }

            if (next - 1 >= 0 && next - 1 <= 100000) {
                if (!visited[next - 1]) {
                    pq.add(new Node(next - 1, cost + 1));
                }
            }

            if (next + 1 >= 0 && next + 1 <= 100000) {
                if (!visited[next + 1]) {
                    pq.add(new Node(next + 1, cost + 1));
                }
            }

            if (next * 2 >= 0 && next * 2 <= 100000) {
                if (!visited[next * 2]) {
                    pq.add(new Node(next * 2, cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int next;
        int value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
