import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] quad;
    static String ans = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        quad = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                quad[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        System.out.println(divideAndConquer(0, 0, n));
    }

    private static String divideAndConquer(int startX, int startY, int size) {
        String part = "";

        if (check(startX, startY, size)) {
            part += String.valueOf(quad[startX][startY]);
        } else {
            part += "(";
            int newSize = size / 2;
            part += divideAndConquer(startX, startY, newSize);
            part += divideAndConquer(startX, startY + newSize, newSize);
            part += divideAndConquer(startX + newSize, startY, newSize);
            part += divideAndConquer(startX + newSize, startY + newSize, newSize);
            part += ")";
        }

        return part;
    }

    private static boolean check(int startX, int startY, int size) {
        int num = quad[startX][startY];

        for (int i = startX; i < startX + size; i++) {
            for (int j = startY; j < startY + size; j++) {
                if (quad[i][j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
