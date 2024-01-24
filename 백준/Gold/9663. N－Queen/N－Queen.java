import java.util.Scanner;

public class Main {

    static int n;
    static boolean[] check;
    static int[] tmp;
    static int[][] chess;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tmp = new int[n + 1];
        check = new boolean[n + 1];
        chess = new int[n + 1][n + 1];

        rec(1);
        System.out.println(cnt);
    }

    private static void rec(int col) {
        if (col == n + 1) {
            cnt++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[col] = i;
                if (possibility(col)) {
                    rec(col + 1);
                }
                check[i] = false;
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 1; i <= col; i++) {
            if (i != col && Math.abs(col - i) == Math.abs(tmp[col] - tmp[i])) {
                return false;
            }
        }
        return true;
    }
}
