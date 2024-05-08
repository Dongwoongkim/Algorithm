import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static boolean[] p;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        p = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            union(x, y);
        }

        for (int i = 1; i <= n; i++) {
            union(i, parent[i]);
        }
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!p[parent[i]]) {
                p[parent[i]] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
            return;
        }

        parent[x] = y;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }
}
