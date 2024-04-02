import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
    static int[] arr;
    static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        tmp = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        rec(0, n, check);

        System.out.println(numbers.peek());
    }

    private static void rec(int pos, int n, boolean[] check) {
        if (pos == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(tmp[i] - tmp[i + 1]);
            }
            numbers.add(sum);
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[pos] = arr[i];
                rec(pos + 1, n, check);
                check[i] = false;
            }
        }
    }
}
