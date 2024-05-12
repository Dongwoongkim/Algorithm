import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static List<List<Integer>> vector = new ArrayList<>();
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            vector.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            vector.get(from).add(to);
            vector.get(to).add(from);
        }

        int nodeNum = -1;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];

            int result = bfs(i);
            if (ans > result) {
                nodeNum = i;
                ans = result;
            }
        }
        System.out.println(nodeNum);
    }

    private static int bfs(int cur) {
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        visited[cur] = true;
        q.add(new Node(cur, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            cnt += node.depth;
            List<Integer> numbers = vector.get(node.num);

            for (int i = 0; i < numbers.size(); i++) {
                Integer next = numbers.get(i);
                if (visited[next] == false) {
                    visited[next] = true;
                    q.add(new Node(next, node.depth + 1));

                }
            }
        }
        return cnt;
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
