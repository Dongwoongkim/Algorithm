import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static Node[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 2];
        visited = new boolean[n + 2];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char species = st.nextToken().charAt(0);
            int amount = Integer.parseInt(st.nextToken());
            int connectNode = Integer.parseInt(st.nextToken());

            nodes[i].species = species;
            nodes[i].amount = amount;

            if (species == 'W') {
                nodes[i].amount *= -1;
            }

            nodes[i].connectNodes.add(connectNode);
            nodes[connectNode].connectNodes.add(i);
        }

        visited[1] = true;

        System.out.println(dfs(1, 0));
    }

    private static long dfs(int cur, long result) {
        List<Integer> connectNodes = nodes[cur].connectNodes;
        long currentSum = result;

        for (int i = 0; i < connectNodes.size(); i++) {
            Integer next = connectNodes.get(i);
            if (!visited[next]) {
                visited[next] = true;
                currentSum += dfs(next, nodes[next].amount);
            }
        }

        if (currentSum >= 0) {
            return currentSum;
        }
        return 0;
    }

    static class Node {
        char species;
        long amount;
        List<Integer> connectNodes;

        public Node() {
            this.connectNodes = new ArrayList<>();
        }

        public Node(char species, int amount) {
            this.species = species;
            this.amount = amount;
        }
    }
}
