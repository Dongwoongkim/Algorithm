import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int wolf;
    static int sheep;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[251][251];
    static char[][] map = new char[251][251];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'v') {
                    wolf++;
                }
                if (map[i][j] == 'k') {
                    sheep++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int x, int y) {
        int s = 0;
        int w = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            if (map[pos.x][pos.y] == 'v') {
                w++;
            }
            if (map[pos.x][pos.y] == 'k') {
                s++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }

                if (visited[nx][ny] == false && map[nx][ny] != '#') {
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        if (s > w) {
            wolf -= w;
        } else {
            sheep -= s;
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
