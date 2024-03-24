import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] arr = new int[101];
    static int[] check = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= 100; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from] = to;
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from] = to;
        }

        bfs(1);

        System.out.println(check[100]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        check[start] = 0;

        while (!q.isEmpty()) {
            int current = q.peek();
            q.poll();

            for (int next = current + 1; next <= current + 6; next++) {
                if (next <= 100) {
                    if (check[arr[next]] == 0) {
                        q.add(arr[next]);
                        check[arr[next]] = check[current] + 1;
                    }
                }
            }
        }
    }
}
