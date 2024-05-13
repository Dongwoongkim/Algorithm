import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int r;
    static int[][] cost;
    static int[] item;
    static final int MAX_COST = 100_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        cost = new int[n + 1][n + 1];
        item = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    cost[i][j] = MAX_COST;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            item[i] = sc.nextInt();
        }

        for (int i = 0; i < r; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int c = sc.nextInt();
            cost[from][to] = c;
            cost[to][from] = c;
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

        int ans = -1;
        for (int start = 1; start <= n; start++) {
            int sum = item[start];
            for (int end = 1; end <= n; end++) {
                if (cost[start][end] != MAX_COST && start != end) {
                    if (cost[start][end] <= m) {
                        sum += item[end];
                    }
                }
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}
