import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> answer = new ArrayList<>();
    static boolean[][][] visited;
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[a + 1][b + 1][c + 1];
        bfs();

        Collections.sort(answer);

        for (Integer i : answer) {
            sb.append(i + " ");
        }

        System.out.println(sb.toString().trim());
    }

    private static void bfs() {
        Queue<PossibleCase> q = new LinkedList<>();
        q.add(new PossibleCase(0, 0, c));
        visited[0][0][c] = true;

        while (!q.isEmpty()) {
            PossibleCase possibleCase = q.poll();

            int a1 = possibleCase.a;
            int b1 = possibleCase.b;
            int c1 = possibleCase.c;

            if (a1 == 0) {
                answer.add(c1);
            }

            // A -> B
            if (a1 + b1 >= b) { // 넘치는 경우
                if (!visited[a1 + b1 - b][b][c1]) {
                    visited[a1 + b1 - b][b][c1] = true;
                    q.add(new PossibleCase(a1 + b1 - b, b, c1));
                }
            } else { // 넘치지 않는 경우
                if (!visited[0][a1 + b1][c1]) {
                    visited[0][a1 + b1][c1] = true;
                    q.add(new PossibleCase(0, a1 + b1, c1));
                }
            }

            // A -> C
            if (a1 + c1 >= c) {
                if (!visited[a1 + c1 - c][b1][c]) {
                    visited[a1 + c1 - c][b1][c] = true;
                    q.add(new PossibleCase(a1 + c1 - c, b1, c));
                }
            } else {
                if (!visited[0][b1][a1 + c1]) {
                    visited[0][b1][a1 + c1] = true;
                    q.add(new PossibleCase(0, b1, a1 + c1));
                }
            }

            // B->A
            if (a1 + b1 >= a) {
                if (!visited[a][a1 + b1 - a][c1]) {
                    visited[a][a1 + b1 - a][c1] = true;
                    q.add(new PossibleCase(a, a1 + b1 - a, c1));
                }
            } else {
                if (!visited[a1 + b1][0][c1]) {
                    visited[a1 + b1][0][c1] = true;
                    q.add(new PossibleCase(a1 + b1, 0, c1));
                }
            }

            // B->C
            if (b1 + c1 >= c) {
                if (!visited[a1][b1 + c1 - c][c]) {
                    visited[a1][b1 + c1 - c][c] = true;
                    q.add(new PossibleCase(a1, b1 + c1 - c, c));
                }
            } else {
                if (!visited[a1][0][b1 + c1]) {
                    visited[a1][0][b1 + c1] = true;
                    q.add(new PossibleCase(a1, 0, b1 + c1));
                }
            }

            // C->A
            if (c1 + a1 >= a) {
                if (!visited[a][b1][c1 + a1 - a]) {
                    visited[a][b1][c1 + a1 - a] = true;
                    q.add(new PossibleCase(a, b1, c1 + a1 - a));
                }
            } else {
                if (!visited[a1 + c1][b1][0]) {
                    visited[a1 + c1][b1][0] = true;
                    q.add(new PossibleCase(a1 + c1, b1, 0));
                }
            }

            // C->B
            if (c1 + b1 >= b) {
                if (!visited[a1][b][c1 + b1 - b]) {
                    visited[a1][b][c1 + b1 - b] = true;
                    q.add(new PossibleCase(a1, b, c1 + b1 - b));
                }
            } else {
                if (!visited[a1][c1 + b1][0]) {
                    visited[a1][c1 + b1][0] = true;
                    q.add(new PossibleCase(a1, c1 + b1, 0));
                }
            }
        }
    }

    static class PossibleCase {
        int a;
        int b;
        int c;

        public PossibleCase(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
