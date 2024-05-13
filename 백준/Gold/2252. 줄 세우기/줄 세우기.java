import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static List<List<Integer>> vector = new ArrayList<>();
    static int[] inputDegree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        inputDegree = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            vector.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            vector.get(from).add(to);

            inputDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inputDegree[i] == 0) {
                queue.add(i);
            }
        }

        TopologicalSorting(queue);
    }

    private static void TopologicalSorting(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.print(cur + " ");
            List<Integer> connectNodeNumbers = vector.get(cur);

            for (int i = 0; i < connectNodeNumbers.size(); i++) {
                Integer next = connectNodeNumbers.get(i);
                inputDegree[next]--;

                if (inputDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
