import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {

            int n = sc.nextInt();
            List<Score> scoresOrderByFirst = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                scoresOrderByFirst.add(new Score(first, second));
            }

            Collections.sort(scoresOrderByFirst);

            int cnt = 1;
            int previous = 0;
            for (int i = 1; i < n; i++) {
                if (scoresOrderByFirst.get(i).second <= scoresOrderByFirst.get(previous).second) {
                    cnt++;
                    previous = i;
                }
            }
            System.out.println(cnt);
        }
    }

    static class Score implements Comparable<Score> {
        int first;
        int second;

        public Score(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(this.first, o.first);
        }
    }
}
