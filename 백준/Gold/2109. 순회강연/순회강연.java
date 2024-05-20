import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static boolean[] check = new boolean[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();

            pq.add(new Lecture(p, d));
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            for (int i = lecture.d; i >= 1; i--) {
                if (!check[i]) {
                    check[i] = true;
                    ans += lecture.p;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    static class Lecture implements Comparable<Lecture> {
        int p;
        int d;

        public Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o) {
            if (o.p == this.p) {
                return Integer.compare(this.d, o.d);
            }

            return Integer.compare(o.p, this.p);
        }
    }
}
