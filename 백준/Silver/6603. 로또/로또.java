import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            arr = new int[n + 1];
            boolean[] check = new boolean[n + 1];
            tmp = new int[7];

            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }

            rec(1, check);

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void rec(int pos, boolean[] check) {
        if (pos == 7) {
            for (int i = 1; i <= 6; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = pos; i <= n; i++) {
            if (check[i] == false && tmp[pos - 1] < arr[i]) {
                check[i] = true;
                tmp[pos] = arr[i];
                rec(pos + 1, check);
                check[i] = false;
            }
        }
    }
}
