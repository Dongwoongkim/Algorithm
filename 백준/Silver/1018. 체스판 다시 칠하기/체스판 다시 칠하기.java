import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());

        Integer n = numbers.get(0);
        Integer m = numbers.get(1);

        char[][] chess = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        System.out.print(Math.min(getWB(chess, n, m), getBW(chess, n, m)));
    }

    private static Integer getWB(char[][] chess, Integer n, Integer m) {
        int ans = 64;
        char[][] squares = {
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray()
        };
        ans = getAnswer(chess, n, m, squares, ans);

        return ans;
    }

    private static Integer getBW(char[][] chess, Integer n, Integer m) {
        int ans = 64;
        char[][] squares = {
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray(),
                "BWBWBWBW".toCharArray(),
                "WBWBWBWB".toCharArray()
        };
        ans = getAnswer(chess, n, m, squares, ans);

        return ans;
    }

    private static int getAnswer(char[][] chess, Integer n, Integer m, char[][] squares, int ans) {
        int x = 0;
        int y = 0;
        int diff = 0;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (chess[k][l] != squares[y][x]) {
                            diff++;
                        }
                        x++;
                    }
                    x = 0;
                    y++;
                }
                y = 0;

                ans = Math.min(ans, diff);
                diff = 0;
            }
        }
        return ans;
    }
}
