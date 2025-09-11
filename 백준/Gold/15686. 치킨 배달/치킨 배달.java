import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[] check;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Position> chickens = new ArrayList<>();
        List<Position> homes = new ArrayList<>();
        map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chickens.add(new Position(i, j));
                }

                if (map[i][j] == 1) {
                    homes.add(new Position(i, j));
                }
            }
        }
        check = new boolean[chickens.size()];

        dfs(homes, chickens, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(List<Position> homes, List<Position> chickens, int cur, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int j = 0; j < homes.size(); j++) {
                int distance = 999_999_999;
                for (int i = 0; i < chickens.size(); i++) {
                    if (check[i] == true) {
                        Position chicken = chickens.get(i);
                        Position home = homes.get(j);
                        distance = Math.min(distance, Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y));
                    }
                }
                sum += distance;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = cur; i < chickens.size(); i++) {
            if (check[i] == false) {
                check[i] = true;
                dfs(homes, chickens, i + 1, cnt + 1);
                check[i] = false;
            }
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
