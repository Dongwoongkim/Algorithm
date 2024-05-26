import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            graph = new int[n + 1];
            visited = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (visited[j] == false) {
                    dfs(j, n);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int start, int n) {
        visited[start] = true;

        int next = graph[start];

        if (visited[next] == false) {
            dfs(next, n);
        }
    }
}
