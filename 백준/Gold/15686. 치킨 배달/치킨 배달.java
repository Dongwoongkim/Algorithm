import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static List<Position> homes = new ArrayList<>();
    static List<Position> chickens = new ArrayList<>();
    static int[] pick;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        pick = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homes.add(new Position(i, j));
                }
                if (map[i][j] == 2) {
                    chickens.add(new Position(i, j));
                }
            }
        }

        rec(0, 0);
        System.out.print(ans);
    }
    private static void rec(int pos, int next) {
        if (pos == m) {
            int sum = 0;

            for (Position hPos : homes) {
                int dist = Integer.MAX_VALUE;

                for (int idx : pick) {
                    Position cPos = chickens.get(idx);
                    int d = Math.abs(cPos.x - hPos.x) + Math.abs(cPos.y - hPos.y);
                    dist = Math.min(dist, d);
                }
                sum += dist;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = next; i < chickens.size(); i++) {
            pick[pos] = i;
            rec(pos + 1, i + 1);
        }
    }

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
