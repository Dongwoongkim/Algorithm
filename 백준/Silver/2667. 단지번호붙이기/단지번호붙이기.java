import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n;
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] area;
    static boolean[][] check;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        area = new char[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                area[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == '1' && check[i][j] == false) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(answer);
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    private static void bfs(int x, int y) {
        int ans = 1;
        check[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            int currentX = q.peek().x;
            int currentY = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (area[nextX][nextY] == '1' && check[nextX][nextY] == false) {
                        ans++;
                        check[nextX][nextY] = true;
                        q.add(new Pair(nextX, nextY));
                    }
                }
            }
        }

        answer.add(ans);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
