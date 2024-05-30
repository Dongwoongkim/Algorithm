import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 데드라인이 짧은 순서 우선순위, 데드라인 동일 시 라면이 큰 것부터 우선순위
        PriorityQueue<Problem> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.deadLine == o2.deadLine) {
                return Integer.compare(o2.ramen, o1.ramen);
            }
            return Integer.compare(o1.deadLine, o2.deadLine);
        });

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(i, deadLine, ramen);
            pq.add(problem);
        }

        // 라면이 작은 것부터
        PriorityQueue<Problem> select = new PriorityQueue<>((o1, o2) -> {
            if (o1.ramen == o2.ramen) {
                return Integer.compare(o1.deadLine, o2.deadLine);
            }
            return Integer.compare(o1.ramen, o2.ramen);
        });

        while (!pq.isEmpty()) {
            Problem problem = pq.poll();

            if (select.size() < problem.deadLine) {
                select.add(problem);
            } else {
                // 데드라인이 더 짧은 문제가 들어올 경우
                // 뽑은 문제중 가장 작은 라면보다 문제의 라면이 크면 뽑은문제를 제거하고 새로운 문제를 넣어줌.
                if (select.peek().ramen < problem.ramen) {
                    select.poll();
                    select.add(problem);
                }
            }
        }
        System.out.println(select.stream().mapToInt(s -> s.ramen).sum());
    }

    static class Problem {
        int number;
        int deadLine;
        int ramen;

        public Problem(int number, int deadLine, int ramen) {
            this.number = number;
            this.deadLine = deadLine;
            this.ramen = ramen;
        }
    }
}
