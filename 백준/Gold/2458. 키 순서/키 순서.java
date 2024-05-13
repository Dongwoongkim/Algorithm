import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static boolean[][] connect;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        connect = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            connect[from][to] = true;
        }

        // 중간노드
        for (int checkPoint = 1; checkPoint <= n; checkPoint++) {
            // 출발 노드
            for (int start = 1; start <= n; start++) {
                // 도착 노드
                for (int end = 1; end <= n; end++) {
                    if (connect[start][checkPoint] == true && connect[checkPoint][end] == true) {
                        connect[start][end] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (connect[i][j] == true || connect[j][i] == true) {
                    cnt++;
                }
            }

            if (cnt == n - 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
