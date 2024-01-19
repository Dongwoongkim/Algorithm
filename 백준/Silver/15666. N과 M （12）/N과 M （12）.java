import static java.util.Arrays.sort;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] tmp;
    static int[] arr;
    static boolean[] check;
    static LinkedHashSet<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        tmp = new int[n + 1];
        arr = new int[n];
        check = new boolean[n + 1];
        set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
        rec(0, 0);

        for (String line : set) {
            sb.append(line);
        }

        System.out.print(sb);
    }

    private static void rec(int pos, int previous) {
        if (pos == m) {
            String ans = "";
            for (int i = 0; i < m; i++) {
                ans += String.valueOf(tmp[i]);
                ans += " ";
            }
            ans += "\n";
            set.add(ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            tmp[pos] = arr[i];
            if (tmp[pos] >= previous) {
                rec(pos + 1, tmp[pos]);
            }
        }
    }
}
