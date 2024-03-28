import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] quad;
    static int f = 0;
    static int s = 0;
    static int t = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        quad = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                quad[i][j] = sc.nextInt();
            }
        }

        divideAndConquer(0, 0, n);

        System.out.println(f);
        System.out.println(s);
        System.out.println(t);
    }

    private static void divideAndConquer(int x, int y, int size) {
        if (checkAllSame(x, y, size)) {
            if (quad[x][y] == -1) {
                f++;
            }
            if (quad[x][y] == 0) {
                s++;
            }
            if (quad[x][y] == 1) {
                t++;
            }
            return;
        }

        int newSize = size / 3;

        divideAndConquer(x, y, newSize);
        divideAndConquer(x, y + (newSize), newSize);
        divideAndConquer(x, y + (newSize) * 2, newSize);

        divideAndConquer(x + (newSize), y, newSize);
        divideAndConquer(x + (newSize), y + (newSize), newSize);
        divideAndConquer(x + (newSize), y + (newSize) * 2, newSize);

        divideAndConquer(x + (newSize) * 2, y, newSize);
        divideAndConquer(x + (newSize) * 2, y + (newSize), newSize);
        divideAndConquer(x + (newSize) * 2, y + (newSize) * 2, newSize);
    }

    private static boolean checkAllSame(int x, int y, int size) {
        int k = quad[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (k != quad[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
