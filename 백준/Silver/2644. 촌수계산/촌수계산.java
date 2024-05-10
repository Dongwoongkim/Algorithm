import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static List<PriorityQueue<Integer>> vector = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 0;
    static boolean isCon = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            vector.add(new PriorityQueue<>());
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            vector.get(node1).add(node2);
            vector.get(node2).add(node1);
        }

        dfs(0, a, b);

        if (!isCon) {
            System.out.println(-1);
        }
    }

    private static void dfs(int cnt, int start, int end) {
        visited[start] = true;
        while (!vector.get(start).isEmpty()) {
            Integer next = vector.get(start).poll();

            if (start == end) {
                System.out.println(cnt);
                isCon = true;
                break;
            }

            if (visited[next] == false) {
                visited[next] = true;
                dfs(cnt + 1, next, end);
            }
        }
    }
}
