import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f + 1];

        int result = bfs(s);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
    }

    private static int bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        visited[start] = true;

        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.num == g) {
                return node.depth;
            }

            if (node.num + u <= f && !visited[node.num + u]) {
                visited[node.num + u] = true;
                queue.add(new Node(node.num + u, node.depth + 1));
            }

            if (node.num - d >= 1 && !visited[node.num - d]) {
                visited[node.num - d] = true;
                queue.add(new Node(node.num - d, node.depth + 1));
            }
        }

        return -1;
    }

    static class Node {
        int num;
        int depth;

        public Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}
