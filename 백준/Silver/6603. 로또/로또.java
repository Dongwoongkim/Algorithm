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
            tmp = new int[6];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);

            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(tmp[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            tmp[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
