import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static boolean[] checkForDfs = new boolean[1001];
    static boolean[] checkForBfs = new boolean[1001];

    static List<List<Integer>> vector = new ArrayList<>();
    static StringBuilder dfsAnswer = new StringBuilder();
    ;
    static StringBuilder bfsAnswer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            vector.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            vector.get(start).add(end);
            vector.get(end).add(start);
        }

        for (int i = 0; i < n + 1; i++) {
            vector.get(i).sort(Comparator.comparingInt(x -> x));
        }

        dfs(k);
        bfs(k);

        System.out.println(dfsAnswer.toString().trim());
        System.out.print(bfsAnswer.toString().trim());
    }

    private static void dfs(int node) {
        checkForDfs[node] = true;
        dfsAnswer.append(node).append(" ");

        for (int i = 0; i < vector.get(node).size(); i++) {
            Integer next = vector.get(node).get(i);

            if (!checkForDfs[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        checkForBfs[node] = true;

        while (!queue.isEmpty()) {
            Integer next = queue.poll();
            bfsAnswer.append(next).append(" ");
            for (int i = 0; i < vector.get(next).size(); i++) {
                if (!checkForBfs[vector.get(next).get(i)]) {
                    queue.add(vector.get(next).get(i));
                    checkForBfs[vector.get(next).get(i)] = true;
                }
            }
        }
    }
}
