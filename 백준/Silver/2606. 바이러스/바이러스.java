import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int cnt = 0;
    static List<List<Integer>> vector = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            vector.add(new ArrayList<>());
        }
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            vector.get(from).add(to);
            vector.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(vector.get(i));
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int start) {
        check[start] = true;

        for (int i = 0; i < vector.get(start).size(); i++) {
            int next = vector.get(start).get(i);
            if (check[next] == false) {
                cnt++;
                dfs(next);
            }
        }
    }
}
