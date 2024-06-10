import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        
        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] cost = new int[n + 1];
            int[] inputDegree = new int[n + 1];
            int[] dp = new int[n + 1];
            List<List<Integer>> vector = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                vector.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                vector.get(from).add(to);
                inputDegree[to]++;
            }

            int goal = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (inputDegree[i] == 0) {
                    dp[i] = cost[i];
                    queue.add(i);
                }
            }
            TopologicalSort(queue, vector, inputDegree, dp, cost);
            System.out.println(dp[goal]);
        }
    }

    private static void TopologicalSort(Queue<Integer> queue, List<List<Integer>> vector,
                                        int[] inputDegree, int[] dp, int[] cost) {

        while (!queue.isEmpty()) {
            Integer prev = queue.poll();

            List<Integer> connectNodes = vector.get(prev);

            for (int i = 0; i < connectNodes.size(); i++) {
                Integer cur = connectNodes.get(i);

                inputDegree[cur]--;
                dp[cur] = Math.max(dp[cur], dp[prev] + cost[cur]);

                if (inputDegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
    }
}
