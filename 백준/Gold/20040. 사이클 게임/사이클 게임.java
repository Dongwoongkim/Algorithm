import java.util.Scanner;

public class Main {

    static int[] parent;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];

        for (int i = 0; i <= n - 1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (!isSameParent(x, y)) {
                union(x, y);
            } else {
                flag = true;
                System.out.println(i);
                break;
            }
        }

        if (!flag) {
            System.out.println(0);
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int num) {
        if (parent[num] == num) {
            return num;
        }

        parent[num] = find(parent[num]);

        return parent[num];
    }
}
