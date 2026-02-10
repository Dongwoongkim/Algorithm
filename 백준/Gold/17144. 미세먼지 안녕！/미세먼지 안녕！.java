import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, t;
    static int[][] map;
    static int machinePos = -1; // 공기청정기 위쪽 행 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (machinePos == -1) {
                        machinePos = i;
                    }
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spreadDust();
            clean();
        }

        System.out.println(getTotalDust());
    }

    static void spreadDust() {
        int[][] tempMap = new int[r][c];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    int spreadAmount = map[i][j] / 5;
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nextX = i + dx[d];
                        int nextY = j + dy[d];

                        if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c) {
                            if (map[nextX][nextY] != -1) {
                                tempMap[nextX][nextY] += spreadAmount;
                                cnt++;
                            }
                        }
                    }
                    tempMap[i][j] += map[i][j] - (spreadAmount * cnt);
                    continue;
                }

                if (map[i][j] == -1) {
                    tempMap[i][j] = -1;
                }
            }
        }

        map = tempMap;
    }

    static void clean() {
        int top = machinePos;
        int bottom = machinePos + 1;

        // 위쪽부분
        // 하
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        // 좌
        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        // 상
        for (int i = 0; i < top; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }
        // 우
        for (int i = c - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
        }

        map[top][1] = 0;

        // 아랫쪽부분
        // 위
        for (int i = bottom + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        // 왼
        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }
        // 아래
        for (int i = r - 1; i > bottom; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        // 우
        for (int i = c - 1; i > 1; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }

        map[bottom][1] = 0;

        map[top][0] = -1;
        map[bottom][0] = -1;
    }

    static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}