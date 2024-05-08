import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static boolean[] visited;

    static List<PriorityQueue<Integer>> vector = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            vector.add(new PriorityQueue<>());
        }

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            vector.get(x).add(y);
            vector.get(y).add(x);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        PriorityQueue<Integer> pq = vector.get(cur);

        while (!pq.isEmpty()) {
            Integer next = pq.poll();
            if (visited[next] == false) {
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}
