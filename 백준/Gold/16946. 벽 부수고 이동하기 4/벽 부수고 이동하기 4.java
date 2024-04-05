import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int n;
    static int m;
    static char[][] map;
    static int[][] sizeMap;
    static boolean[][] check;
    static Map<Integer, Integer> groupSize = new HashMap<>();
    static int k = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        check = new boolean[n + 1][m + 1];
        sizeMap = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0' && check[i][j] == false) {
                    int result = bfs(i, j);
                    groupSize.put(k, result);
                    k++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    int cnt = 1;
                    Set<Integer> groupSet = new HashSet<>();
                    for (int l = 0; l < 4; l++) {
                        int nextX = i + dx[l];
                        int nextY = j + dy[l];
                        if (isPositionInArea(nextX, nextY) && map[nextX][nextY] == '0') {
                            groupSet.add(sizeMap[nextX][nextY]);
                        }
                    }

                    for (Integer size : groupSet) {
                        cnt += groupSize.get(size);
                    }

                    sb.append(cnt % 10);
                }

                if (map[i][j] == '0') {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int bfs(int startX, int startY) {
        int cnt = 1;

        check[startX][startY] = true;
        sizeMap[startX][startY] = k;

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startX, startY));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int curX = pos.x;
            int curY = pos.y;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (isPositionInArea(nextX, nextY) && check[nextX][nextY] == false && map[nextX][nextY] == '0') {
                    cnt++;
                    check[nextX][nextY] = true;
                    sizeMap[nextX][nextY] = k;
                    queue.add(new Position(nextX, nextY));
                }
            }
        }

        return cnt;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isPositionInArea(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < n && nextY < m;
    }
}
