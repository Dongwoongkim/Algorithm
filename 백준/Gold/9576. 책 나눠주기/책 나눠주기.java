import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static boolean[] check;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            cnt = 0;
            parent = new int[n + 1];
            check = new boolean[n + 1];

            for (int j = 0; j <= n; j++) {
                parent[j] = j;
            }

            List<Pair> pairs = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();

                pairs.add(new Pair(from, to));
            }

            Collections.sort(pairs);

            for (int j = 0; j < m; j++) {
                Pair pair = pairs.get(j);

                for (int k = pair.from; k <= pair.to; k++) {
                    if (check[k] == false) {
                        check[k] = true;
                        cnt++;
                        break;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static class Pair implements Comparable<Pair> {
        int from;
        int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.to == o.to) {
                return Integer.compare(o.from, this.from);
            }
            return Integer.compare(this.to, o.to);
        }
    }
}
