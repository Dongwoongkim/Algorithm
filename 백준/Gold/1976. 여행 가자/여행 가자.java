import java.util.Scanner;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int connect = sc.nextInt();

                if (connect == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int from = sc.nextInt();
        for (int i = 1; i < m; i++) {
            int to = sc.nextInt();
            if (!isParentSame(from, to)) {
                System.out.println("NO");
                return;
            }

            from = to;
        }

        System.out.println("YES");
    }

    private static boolean isParentSame(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        return false;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }
}
