import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static boolean[] visited = new boolean[100_001];
    static int ans = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(ans);
        System.out.println(cnt);
    }

    private static void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        visited[start] = true;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            int now = curNode.now;
            int cost = curNode.cost;

            if (now == m) {
                if (cnt == 0) {
                    ans = cost;
                    cnt++;
                } else if (cnt > 0 && ans == cost) {
                    cnt++;
                }
            }

            visited[now] = true;

            if (now * 2 >= 0 && now * 2 <= 100000) {
                if (visited[now * 2] == false) {
                    pq.add(new Node(now * 2, cost + 1));
                }
            }

            if (now + 1 >= 0 && now + 1 <= 100000) {
                if (visited[now + 1] == false) {
                    pq.add(new Node(now + 1, cost + 1));
                }
            }

            if (now - 1 >= 0 && now - 1 <= 100000) {
                if (visited[now - 1] == false) {
                    pq.add(new Node(now - 1, cost + 1));
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
