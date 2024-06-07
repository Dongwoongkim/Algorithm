import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime = new boolean[10001];
    static int[] numbers = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스로 ~9999의 소수 판정
        for (int i = 0; i <= 9999; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= 100; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 9999; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ans = bfs(start, end);

            if (ans == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(ans);
            }
        }
    }

    private static int bfs(int start, int end) {
        boolean[] visited = new boolean[10001];

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.number == end) {
                return node.depth;
            }

            // 한글자씩 바꿔서 진행
            String number = String.valueOf(node.number);

            for (int i = 0; i < 4; i++) {
                // i번째 자릿수를 j로 바꿔서 소수고 방문하지 않은경우 진행
                for (int j = 0; j <= 9; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(number);
                    sb.setCharAt(i, (char) (j + '0'));

                    int nextNumber = Integer.parseInt(sb.toString());
                    if (nextNumber > 999 && isPrime[nextNumber] && !visited[nextNumber]) {
                        visited[nextNumber] = true;
                        queue.add(new Node(nextNumber, node.depth + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int number;
        int depth;

        public Node(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
}
