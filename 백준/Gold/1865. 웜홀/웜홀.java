import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static List<Node> nodes = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes.add(new Node(start, end, weight));
                nodes.add(new Node(end, start, weight));
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                nodes.add(new Node(start, end, -1 * weight));
            }

            sb.append(bellandFord(n)).append("\n");
        }

        System.out.println(sb);
    }

    private static String bellandFord(int n) {
        long[] distances = new long[n + 1];

        for (int i = 0; i < n; i++) {
            boolean changed = false;
            for (Node node : nodes) {
                if (distances[node.end] > distances[node.start] + node.weight) {
                    distances[node.end] = distances[node.start] + node.weight;
                    changed = true;

                    if (i == n - 1) {
                        return "YES";
                    }
                }
            }

            if (!changed) {
                break;
            }
        }

        return "NO";
    }

    static class Node {

        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
