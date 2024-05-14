import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] inputDegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            List<List<Integer>> vector = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                vector.add(new ArrayList<>());
            }

            int[] arr = new int[n + 1];
            inputDegree = new int[n + 1];

            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    vector.get(arr[j]).add(arr[k]);
                    inputDegree[arr[k]]++;
                }
            }

            m = sc.nextInt();

            for (int j = 0; j < m; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                if (vector.get(to).contains(from)) {
                    vector.get(to).remove(Integer.valueOf(from));
                    inputDegree[from]--;
                    vector.get(from).add(to);
                    inputDegree[to]++;
                } else if (vector.get(from).contains(to)) {
                    vector.get(from).remove(Integer.valueOf(to));
                    inputDegree[to]--;
                    vector.get(to).add(from);
                    inputDegree[from]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (inputDegree[arr[j]] == 0) {
                    queue.add(arr[j]);
                }
            }

            System.out.println(TopologicalSorting(queue, vector));
        }
    }

    private static String TopologicalSorting(Queue<Integer> queue, List<List<Integer>> vector) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        while (!queue.isEmpty()) {
          
            if (queue.size() > 1) {
                return "?";
            }
            Integer cur = queue.poll();
            sb.append(cur + " ");
            cnt++;
            if (cnt == n) {
                return sb.toString();
            }
            
            List<Integer> connectNodeNumbers = vector.get(cur);
            for (int i = 0; i < connectNodeNumbers.size(); i++) {
                Integer next = connectNodeNumbers.get(i);
                inputDegree[next]--;

                if (inputDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return "IMPOSSIBLE";
    }
}
