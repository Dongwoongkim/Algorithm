import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int x;
    static int answer = -1;
    static boolean[] visited;
    static int[] distance;
    static int[] cost;
    static List<List<Node>> vector = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();

        distance = new int[n + 1];
        cost = new int[n + 1];

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

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            visited = new boolean[n + 1];
            for (int j = 0; j <= n; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            dijkstra(i);
            cost[i] = distance[x];
        }

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            visited = new boolean[n + 1];
            for (int j = 0; j <= n; j++) {
                distance[j] = Integer.MAX_VALUE;
            }
            dijkstra(x);
            cost[i] += distance[i];
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.max(cost[i], answer);
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        // 비용이 낮은 노드 우선적으로 갱신
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int next = cur.next;

            visited[next] = true;

            // 현재 노드와 이어진 노드들 검사
            List<Node> connectNodes = vector.get(next);

            // 연결 노드와 이어진 노드들을 최소비용으로 갱신
            for (Node connectNode : connectNodes) {
                if (visited[connectNode.next] == false) {
                    if (distance[cur.next] + connectNode.value < distance[connectNode.next]) {
                        distance[connectNode.next] = distance[cur.next] + connectNode.value;
                        q.add(new Node(connectNode.next, distance[connectNode.next]));
                    }
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
