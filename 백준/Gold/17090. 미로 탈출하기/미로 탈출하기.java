import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static int n;
    static int m;
    static char[][] map;
    static int[][] check;
    static Map<Character, Pair> next = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        initNextMap(next);
        map = new char[n + 1][m + 1];
        check = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                check[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += dfs(i, j);
            }
        }

        System.out.println(cnt);
    }

    private static void initNextMap(Map<Character, Pair> next) {
        next.put('D', new Pair(1, 0));
        next.put('U', new Pair(-1, 0));
        next.put('L', new Pair(0, -1));
        next.put('R', new Pair(0, 1));
    }

    private static int dfs(int x, int y) {
        // 현재 위치가 바깥 경계인 경우
        if ((x < 0) || (y < 0) || (x >= n) || (y >= m)) {
            return 1;
        }

        // 현재 위치에 방문한 적이 있는 경우
        if (check[x][y] != -1) {
            return check[x][y];
        }

        // 처음 방문하는 경우
        check[x][y] = 0;
        char c = map[x][y];
        Pair pair = next.get(c);
        int nextX = x + pair.dx;
        int nextY = y + pair.dy;

        // 현재 위치 = 다음 위치기반으로 초기화
        check[x][y] = dfs(nextX, nextY);

        // 현재 위치 리턴하여 이전 위치값 초기화
        return check[x][y];
    }

    static class Pair {
        int dx;
        int dy;

        public Pair(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }
}
