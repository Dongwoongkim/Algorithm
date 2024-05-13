import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int ans = Integer.MAX_VALUE;
    static int[][] cost;
    static final int MAX_COST = 401 * 10001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    cost[i][j] = MAX_COST;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            cost[from][to] = sc.nextInt();
        }

        // 중간노드
        for (int checkPoint = 1; checkPoint <= n; checkPoint++) {
            // 출발 노드
            for (int start = 1; start <= n; start++) {
                // 도착 노드
                for (int end = 1; end <= n; end++) {
                    cost[start][end] = Math.min(cost[start][end], cost[start][checkPoint] + cost[checkPoint][end]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (cost[i][j] != MAX_COST && cost[j][i] != MAX_COST) {
                    ans = Math.min(ans, cost[i][j] + cost[j][i]);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
