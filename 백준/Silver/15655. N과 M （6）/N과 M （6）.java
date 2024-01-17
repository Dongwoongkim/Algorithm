import static java.util.Arrays.sort;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] tmp;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        tmp = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1 7 8 9
        sort(arr);
        rec(0, 0);

        System.out.print(sb);
    }

    private static void rec(int pos, int previous) {
        if (pos == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            tmp[pos] = arr[i];
            if (tmp[pos] > previous) {
                rec(pos + 1, tmp[pos]);
            }

        }
    }
}
