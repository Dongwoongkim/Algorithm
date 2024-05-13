import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] cost;
    static final int MAX_COST = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = MAX_COST;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int c = sc.nextInt();
            cost[from][to] = Math.min(cost[from][to], c);
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
                if (cost[i][j] == MAX_COST) {
                    cost[i][j] = 0;
                }
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}
