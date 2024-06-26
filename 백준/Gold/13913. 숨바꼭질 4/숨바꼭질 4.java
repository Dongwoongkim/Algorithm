import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[] visited = new boolean[100_001];
    static int[] parent = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(n);

        int start = m;

        List<Integer> answer = new ArrayList<>();

        while (true) {
            answer.add(start);
            if (start == n) {
                break;
            }
            start = parent[start];
        }

        Collections.reverse(answer);

        for (Integer num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            int now = curNode.now;
            int cost = curNode.cost;

            visited[now] = true;

            if (now == m) {
                System.out.println(cost);
                return;
            }

            if (now * 2 >= 0 && now * 2 <= 100000) {
                if (visited[now * 2] == false) {
                    pq.add(new Node(now * 2, cost + 1));
                    parent[now * 2] = now;
                    visited[now * 2] = true;
                }
            }

            if (now + 1 >= 0 && now + 1 <= 100000) {
                if (visited[now + 1] == false) {
                    pq.add(new Node(now + 1, cost + 1));
                    parent[now + 1] = now;
                    visited[now + 1] = true;
                }
            }

            if (now - 1 >= 0 && now - 1 <= 100000) {
                if (visited[now - 1] == false) {
                    pq.add(new Node(now - 1, cost + 1));
                    parent[now - 1] = now;
                    visited[now - 1] = true;
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int now;
        int cost;

        public Node(int now, int cost) {
            this.now = now;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
