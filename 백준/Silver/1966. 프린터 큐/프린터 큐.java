import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Paper> papers = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                papers.add(new Paper(j, Integer.parseInt(st.nextToken())));
            }

            int answer = 0;
            while (!papers.isEmpty()) {
                Paper current = papers.poll();

                boolean flag = false;
                
                // 큐검사
                for (Paper p : papers) {
                    if (p.priority > current.priority) {
                        flag = true;
                        break;
                    }
                }
                
                if (flag) {
                    papers.add(current);
                } else {
                    answer++;
                    if (current.order == m) {
                        sb.append(answer).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class Paper {

        int order;
        int priority;

        public Paper(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
