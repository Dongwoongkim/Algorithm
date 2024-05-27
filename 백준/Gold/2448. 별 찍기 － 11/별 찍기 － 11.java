import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] pattern = {
            {' ', ' ', '*', ' ', ' '},
            {' ', '*', ' ', '*', ' '},
            {'*', '*', '*', '*', '*'}};

    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        map = new char[n + 1][n * 2 + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                map[i][j] = ' ';
            }
        }

        dq(n / 3, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dq(int t, int x, int y) {
        if (t == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    map[x + i][y + j] = pattern[i][j];
                }
            }
            return;
        }

        int next = t / 2;
        dq(next, x, y + 3 * next);
        dq(next, x + 3 * next, y);
        dq(next, x + 3 * next, y + 3 * t);
    }
}
