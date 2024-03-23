import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static List<List<Integer>> vector = new ArrayList<>();
    static boolean[] check;
    static int[] bfsResult;
    static int[] dfsResult;
    static int idx = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        check = new boolean[n + 1];
        bfsResult = new int[n + 1];
        dfsResult = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            vector.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            vector.get(from).add(to);
            vector.get(to).add(from);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(vector.get(i));
        }

        dfs(v);

        for (int i = 0; i < n; i++) {
            if (dfsResult[i] != 0) {
                System.out.print(dfsResult[i] + " ");
            }
        }

        Arrays.fill(check, false);
        idx = 0;
        bfs(v);

        System.out.println();
        for (int i = 0; i < n; i++) {
            if (bfsResult[i] != 0) {
                System.out.print(bfsResult[i] + " ");
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int next = queue.peek();
            bfsResult[idx++] = next;
            queue.poll();

            for (int i = 0; i < vector.get(next).size(); i++) {
                if (check[vector.get(next).get(i)] == false) {
                    check[vector.get(next).get(i)] = true;
                    queue.add(vector.get(next).get(i));
                }
            }
        }
    }

    private static void dfs(int start) {
        check[start] = true;
        dfsResult[idx++] = start;

        for (int i = 0; i < vector.get(start).size(); i++) {
            int next = vector.get(start).get(i);

            if (check[next] == false) {
                dfs(next);
            }
        }
    }
}
