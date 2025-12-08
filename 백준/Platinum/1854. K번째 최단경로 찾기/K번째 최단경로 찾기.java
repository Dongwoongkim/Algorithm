import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int v, e, k;
    static List<List<Node>> vector = new ArrayList<>();
    static List<PriorityQueue<Integer>> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            vector.add(new ArrayList<>());
            answers.add(new PriorityQueue<>(Collections.reverseOrder()));
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vector.get(start).add(new Node(end, weight));
        }

        dstr(1);

        for (int i = 1; i <= v; i++) {
            if (answers.get(i).size() < k) {
                System.out.println(-1);
            }
            else {
                System.out.println(answers.get(i).peek());
            }
        }
    }

    private static void dstr(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );

        answers.get(start).add(0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : vector.get(cur.num)) {
                int cost = cur.weight + next.weight;
                PriorityQueue<Integer> answerList = answers.get(next.num);

                if (answerList.size() < k) {
                    answerList.add(cost);
                    pq.add(new Node(next.num, cost));
                    continue;
                }

                if (answerList.peek() > cost) {
                    answerList.poll();
                    answerList.add(cost);

                    pq.add(new Node(next.num, cost));
                }
            }
        }
    }

    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
