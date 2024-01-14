import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] pattern = {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}};
        char[][] star = new char[6562][6562];

        int n = Integer.parseInt(br.readLine());

        fillStar(star, pattern, n, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void fillStar(char[][] star, char[][] pattern, int n, int x, int y) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    star[y + i][x + j] = pattern[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    fillSpace(star, n / 3, x + j * (n / 3), y + i * (n / 3));
                    continue;
                }
                fillStar(star, pattern, n / 3, x + j * (n / 3), y + i * (n / 3));
            }
        }
    }

    private static void fillSpace(char[][] star, int n, int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[y + i][x + j] = ' ';
            }
        }
    }
}
