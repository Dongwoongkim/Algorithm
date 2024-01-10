import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        move(q);
    }

    private static void move(Queue<Integer> q) {
        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
    }
}
