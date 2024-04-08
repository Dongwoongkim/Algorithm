import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ans = 4001;
    static int n;
    static int m;
    static char[][] map;
    static boolean[] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int robotX;
    static int robotY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            map = new char[n + 1][m + 1];

            List<Position> dirties = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        dirties.add(new Position(i, j));
                    }
                    if (map[i][j] == 'o') {
                        robotX = i;
                        robotY = j;
                    }
                }
            }

            int dirtySize = dirties.size();
            check = new boolean[dirtySize];

            int[] tmp = new int[dirtySize];
            int[][] distances = new int[12][12];
            dfs(0, dirtySize, tmp, dirties, distances);
            if (ans == 4001) {
                ans = -1;
            }
            sb.append(ans).append("\n");
            ans = 4001;
        }

        System.out.println(sb);
    }

    private static void dfs(int cnt, int size, int[] tmp, List<Position> dirties, int[][] distances) {
        if (cnt == size) {
            int result;
            if (distances[11][tmp[0]] != 0) {
                result = distances[11][tmp[0]];
            } else {
                result = bfs(-1, tmp[0], dirties, distances);
            }

            for (int i = 0; i < size - 1; i++) {
                if (distances[tmp[i]][tmp[i + 1]] == 0 && distances[tmp[i + 1]][tmp[i]] == 0) {
                    int bfs = bfs(tmp[i], tmp[i + 1], dirties, distances);
                    if (bfs == -1) {
                        return;
                    }
                    result += bfs;
                } else {
                    result += distances[tmp[i]][tmp[i + 1]];
                }
            }
            ans = Math.min(result, ans);
        }

        for (int i = 0; i < size; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[cnt] = i;
                dfs(cnt + 1, size, tmp, dirties, distances);
                check[i] = false;
            }
        }
    }

    private static int bfs(int from, int to, List<Position> dirties, int[][] distances) {
        boolean[][] check = new boolean[n + 1][m + 1];
        int[][] trace = new int[n + 1][m + 1];

        Queue<Position> queue = new LinkedList<>();

        if (from == -1) {
            queue.add(new Position(robotX, robotY));
            check[robotX][robotY] = true;
        } else {
            queue.add(new Position(dirties.get(from).x, dirties.get(from).y));
            check[dirties.get(from).x][dirties.get(from).y] = true;
        }

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            int curX = pos.x;
            int curY = pos.y;

            if (curX == dirties.get(to).x && curY == dirties.get(to).y) {
                if (from != -1) {
                    distances[from][to] = trace[curX][curY];
                    distances[to][from] = trace[curX][curY];
                }

                if (from == -1) {
                    distances[11][to] = trace[curX][curY];
                    distances[to][11] = trace[curX][curY];
                }
                return trace[curX][curY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isInArea(nextX, nextY) && check[nextX][nextY] == false && map[nextX][nextY] != 'x') {
                    check[nextX][nextY] = true;
                    trace[nextX][nextY] = trace[curX][curY] + 1;
                    queue.add(new Position(nextX, nextY));
                }
            }
        }

        return -1;
    }

    private static boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
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
