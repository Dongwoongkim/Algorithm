import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int v, e;
    static long[] dp;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        dp = new long[v + 1];

        for (int i = 0; i <= v; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        bf(1);
    }

    private static void bf(int start) {
        dp[start] = 0;

        // 정점 사이의 최단 경로 = 최대 V−1
        // 갱신이 일어나지 않은경우 조기종료
        // start에서 end로 가는 weight를 최대 v-1번 갱신하여 시작노드로부터 최소비용을 계산
        for (int i = 0; i < v - 1; i++) {
            boolean changed = false;
            for (Edge edge : edges) {
                if (dp[edge.start] != Integer.MAX_VALUE && dp[edge.start] + edge.weight < dp[edge.end]) {
                    dp[edge.end] = dp[edge.start] + edge.weight;
                    changed = true;
                }
            }

            if(!changed) break;
        }

        // v-1번 갱신한 이후 한번 더 갱신했을ㄹ떄
        // 음수 가중치로 갱신이 발생하면 음수사이클
        for (Edge edge : edges) {
            if (dp[edge.start] != Integer.MAX_VALUE && dp[edge.start] + edge.weight < dp[edge.end]) {
                System.out.print(-1);
                return;
            }
        }

        for (int i = 2; i <= v; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dp[i]);
            }
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
