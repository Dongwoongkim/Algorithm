import java.util.Scanner;

public class Main {

    static int n;
    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        paper = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        divideAndConquer(0, 0, n);
        System.out.print(white + "\n" + blue);
    }

    private static void divideAndConquer(int startX, int startY, int size) {
        if (isEqualToColor(startX, startY, size, paper)) {
            int color = paper[startX][startY];
            if (color == 0) {
                white++;
                return;
            }
            if (color == 1) {
                blue++;
                return;
            }
        }

        divideAndConquer(startX, startY, size / 2);
        divideAndConquer(startX, startY + (size / 2), size / 2);
        divideAndConquer(startX + (size / 2), startY, size / 2);
        divideAndConquer(startX + (size / 2), startY + (size / 2), size / 2);
    }

    private static boolean isEqualToColor(int startX, int startY, int size, int[][] paper) {
        int color = paper[startX][startY];
        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
