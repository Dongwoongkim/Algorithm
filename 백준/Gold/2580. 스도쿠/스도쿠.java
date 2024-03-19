import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static boolean done = false;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] sdocu = new int[9][9];

        List<Pair> zeros = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sdocu[i][j] = sc.nextInt();
                if (sdocu[i][j] == 0) {
                    zeros.add(new Pair(i, j));
                }
            }
        }

        rec(0, zeros, sdocu);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sdocu[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rec(int current, List<Pair> zeros, int[][] sdocu) {
        if (current == zeros.size()) {
            done = true;
            return;
        }

        Pair pair = zeros.get(current);
        int x = pair.x;
        int y = pair.y;

        for (int i = 1; i <= 9; i++) {
            sdocu[x][y] = i;
            if (check(x, y, sdocu)) {
                rec(current + 1, zeros, sdocu);
            }
            if (done) {
                return;
            }
        }

        sdocu[x][y] = 0;
    }

    private static boolean check(int x, int y, int[][] sdocu) {
        int number = sdocu[x][y];

        // 가로 check
        for (int i = 0; i < 9; i++) {
            if (i != x && sdocu[i][y] == number) {
                return false;
            }
        }

        // 세로 check
        for (int i = 0; i < 9; i++) {
            if (i != y && sdocu[x][i] == number) {
                return false;
            }
        }

        // 3*3 정사각형 내부에 겹치는 숫자 check
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (sdocu[i][j] == sdocu[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
