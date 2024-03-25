import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int t;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            List<List<Integer>> vector = new ArrayList<>();
            check = new boolean[v + 1];

            for (int j = 0; j < v + 1; j++) {
                vector.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                vector.get(from).add(to);
                vector.get(to).add(from);
            }

            for (int j = 0; j < v + 1; j++) {
                Collections.sort(vector.get(j));
            }

            System.out.println(extracted(v, vector));
        }
    }

    private static String extracted(int v, List<List<Integer>> vector) {
        for (int j = 1; j <= v; j++) {
            if (check[j] == false) {
                if (!bfs(j, vector, v)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static boolean bfs(int start, List<List<Integer>> vector, int v) {
        int[] color = new int[v + 1];

        color[start] = 1;
        check[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Integer current = q.poll();

            for (int i = 0; i < vector.get(current).size(); i++) {
                int next = vector.get(current).get(i);
                if (check[next] == true && color[next] == color[current]) {
                    return false;
                }
                if (check[next] == false && color[next] == 0) {
                    color[next] = color[current] * -1;
                    check[next] = true;
                    q.add(next);
                }
            }
        }
        return true;
    }
}
