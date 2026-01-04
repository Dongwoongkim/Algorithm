import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, q;
    static List<List<Integer>> vectors = new ArrayList<>();
    static List<Edge> edges = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            vectors.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            vectors.get(start).add(end);
            vectors.get(end).add(start);
            edges.add(new Edge(start, end));
        }

        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());

            sb.append(getAnswer(query, node)).append('\n');
        }

        System.out.print(sb);
    }

    private static String getAnswer(int query, int node) {
        if (query == 1) {
            return isCutVertex(node);
        }

        return "yes";
    }

    private static String isCutVertex(int node) {
        if (vectors.get(node).size() >= 2) {
            return "yes";
        }
        return "no";
    }

    static class Edge {

        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
