import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(start, end));
        }

        Collections.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures.get(0).end);

        for (int i = 1; i < n; i++) {
            // 배정한 강의의 종료시간이 끝나자마자 바로 강의를 배정할 수 있는 것 배정
            if (lectures.get(i).start >= pq.peek()) {
                pq.poll();
            }

            pq.add(lectures.get(i).end);
        }

        System.out.println(pq.size());

    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(this.start, o.start);
        }
    }
}
