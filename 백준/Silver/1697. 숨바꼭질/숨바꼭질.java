import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static List<List<Integer>> v = new ArrayList<>();
    static boolean[] check = new boolean[100001];
    static int[] ans = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i <= 100000; i++) {
            v.add(new ArrayList<>());
        }

        bfs(n);
        System.out.println(ans[k]);
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] = true;
        ans[n] = 0;

        while (!q.isEmpty()) {
            Integer current = q.peek();
            q.poll();

            int left = current - 1;
            int middle = current + 1;
            int right = current * 2;

            if (left >= 0 && left <= 100000 && !check[left]) {
                check[left] = true;
                ans[left] = ans[current] + 1;
                q.add(left);
            }
            if (middle >= 0 && middle <= 100000 && !check[middle]) {
                check[middle] = true;
                ans[middle] = ans[current] + 1;
                q.add(middle);
            }
            if (right >= 0 && right <= 100000 && !check[right]) {
                check[right] = true;
                ans[right] = ans[current] + 1;
                q.add(right);
            }

            if (right == k || middle == k || left == k) {
                break;
            }
        }
    }
}
