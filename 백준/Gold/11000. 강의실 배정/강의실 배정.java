import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Lecture> lectures = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(start, end));
        }

        // 시작시간 빠른 순서대로 정렬
        Collections.sort(lectures);

        System.out.print(getAnswer());
    }

    private static int getAnswer() {
        // 빨리 끝나는 순서대로 뽑기
        PriorityQueue<Lecture> pq = new PriorityQueue<>(
            (a, b) -> (a.end - b.end)
        );

        pq.add(lectures.get(0));

        // 시작시간 빠른순서대로 iter
        for (int i = 1; i < n; i++) {
            Lecture lecture = lectures.get(i);

            if (pq.peek().end <= lecture.start) {
                pq.poll();
            }

            pq.add(lecture);
        }

        return pq.size();
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
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }
}
