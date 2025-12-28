import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static List<Lecture> lectures = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        // 종료시간 빠른순서대로 정렬
        Collections.sort(lectures);

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int cnt = 1;

        // 각 회의실의 마지막 종료 시간
        List<Integer> rooms = new ArrayList<>();
        rooms.add(lectures.get(0).end);

        for (int i = 1; i < n; i++) {
            Lecture lecture = lectures.get(i);
            int idx = -1;
            int end = -1;

            // 회의실 돌면서 회의 넣을 수 있으면 넣기
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j) < lecture.start && rooms.get(j) > end) {
                    end = rooms.get(j);
                    idx = j;
                }
            }

            if (idx != -1) {
                rooms.set(idx, lecture.end); // 기존 회의실 사용
                cnt++;
            } else if (rooms.size() < k) {
                rooms.add(lecture.end); // 새 회의실 사용
                cnt++;
            }
        }

        return cnt;
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
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
