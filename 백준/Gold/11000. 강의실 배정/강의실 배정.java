import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;

    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Class> classes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            classes.add(new Class(start, end));
        }

        Collections.sort(classes);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(classes.get(0).end);

        for (int i = 1; i < n; i++) {
            if (pq.peek() <= classes.get(i).start) {
                pq.poll();
            }
            pq.add(classes.get(i).end);
        }

        System.out.println(pq.size());
    }

    static class Class implements Comparable<Class> {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class other) {
            return Integer.compare(this.start, other.start);
        }
    }
}
