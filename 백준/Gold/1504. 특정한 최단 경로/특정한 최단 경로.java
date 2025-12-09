import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, e;
    static List<List<Node>> vectors = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            vectors.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            vectors.get(start).add(new Node(end, weight));
            vectors.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // case1) 1 -> a -> b - > n
        int oneToA = dstr(1, a);
        int aToB = dstr(a, b);
        int bToN = dstr(b, n);

        int oneToB = dstr(1, b);
        int bToA = dstr(b, a);
        int aToN = dstr(a, n);

        int case1 = oneToA + aToB + bToN;
        int case2 = oneToB + bToA + aToN;
        
        if (oneToA == Integer.MAX_VALUE || aToB == Integer.MAX_VALUE || bToN == Integer.MAX_VALUE) {
            case1 = Integer.MAX_VALUE;
        }
        if (oneToB == Integer.MAX_VALUE || bToA == Integer.MAX_VALUE || aToN == Integer.MAX_VALUE) {
            case2 = Integer.MAX_VALUE;
        }

        int ans = Math.min(case1, case2);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//        System.out.println(case1);
//        System.out.println(case2);
//        System.out.println(Integer.MAX_VALUE);
    }

    private static int dstr(int start, int end) {
        dp = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.weight - b.weight
        );

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int curNodeNum = curNode.num;

            if (!check[curNodeNum] && dp[curNodeNum] != Integer.MAX_VALUE) {
                check[curNodeNum] = true;

                List<Node> nextNodes = vectors.get(curNodeNum);
                for (Node nextNode : nextNodes) {
                    if (dp[nextNode.num] > dp[curNodeNum] + nextNode.weight) {
                        dp[nextNode.num] = dp[curNode.num] + nextNode.weight;
                        pq.add(new Node(nextNode.num, dp[nextNode.num]));
                    }
                }
            }
        }

        return dp[end];
    }

    static class Node {

        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

}
