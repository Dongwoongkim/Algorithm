import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Conference> conferences = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            conferences.add(new Conference(start, end));
        }

        Collections.sort(conferences);

        int ans = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            int startTime = conferences.get(i).start;
            if (startTime >= endTime) {
                endTime = conferences.get(i).end;
                ans++;
            }
        }

        System.out.println(ans);
    }

    static class Conference implements Comparable<Conference> {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference other) {
            if (this.end == other.end) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }
}
