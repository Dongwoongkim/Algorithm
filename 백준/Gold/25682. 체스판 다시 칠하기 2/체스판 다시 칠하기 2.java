import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int ans = 2000 * 2000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        List<Integer> numbers = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer n = numbers.get(0);
        Integer m = numbers.get(1);
        Integer k = numbers.get(2);
        String[] chess = new String[n + 1];

        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine();
        }

        char[][] chess1 = new char[n + 1][m + 1];
        char[][] chess2 = new char[n + 1][m + 1];

        int[][] sumOfChess1 = new int[n + 1][m + 1];
        int[][] sumOfChess2 = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        chess1[i][j] = 'B';
                        chess2[i][j] = 'W';
                    }
                    if (j % 2 == 1) {
                        chess1[i][j] = 'W';
                        chess2[i][j] = 'B';
                    }
                }
                if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        chess1[i][j] = 'W';
                        chess2[i][j] = 'B';
                    }
                    if (j % 2 == 1) {
                        chess1[i][j] = 'B';
                        chess2[i][j] = 'W';
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chess1[i][j] != chess[i].charAt(j)) {
                    sumOfChess1[i + 1][j + 1] = 1;
                } else {
                    sumOfChess1[i + 1][j + 1] = 0;
                }

                if (chess2[i][j] != chess[i].charAt(j)) {
                    sumOfChess2[i + 1][j + 1] = 1;
                } else {
                    sumOfChess2[i + 1][j + 1] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sumOfChess1[i][j] = sumOfChess1[i][j - 1] + sumOfChess1[i][j];
                sumOfChess2[i][j] = sumOfChess2[i][j - 1] + sumOfChess2[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sumOfChess1[i][j] += sumOfChess1[i - 1][j];
                sumOfChess2[i][j] += sumOfChess2[i - 1][j];
            }
        }

        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                ans = Math.min(ans,
                        sumOfChess1[i + k - 1][j + k - 1]
                                - sumOfChess1[i + k - 1][j - 1]
                                - sumOfChess1[i - 1][j + k - 1]
                                + sumOfChess1[i - 1][j - 1]);

                ans = Math.min(ans,
                        sumOfChess2[i + k - 1][j + k - 1]
                                - sumOfChess2[i + k - 1][j - 1]
                                - sumOfChess2[i - 1][j + k - 1]
                                + sumOfChess2[i - 1][j - 1]);
            }
        }

        System.out.println(ans);
    }
}
