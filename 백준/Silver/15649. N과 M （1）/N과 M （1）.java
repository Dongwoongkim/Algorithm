import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] tmp;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        tmp = new int[n + 1];
        check = new boolean[n + 1];

        rec(0, n, m, check, tmp);

        System.out.print(sb);
    }

    private static void rec(int pos, int n, int m, boolean[] check, int[] tmp) {
        if (pos == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[pos] = i;
                rec(pos + 1, n, m, check, tmp);
                check[i] = false;
            }
        }
    }
}
