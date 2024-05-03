import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
                continue;
            }

            sb.append(isParentSame(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
            return;
        }

        parent[a] = b;
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);

        return parent[a];
    }

    private static String isParentSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return "YES";
        }

        return "NO";
    }
}
