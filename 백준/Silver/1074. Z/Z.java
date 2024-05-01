import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int n;
    static int r;
    static int c;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        int length = (int) Math.pow(2, n);

        divideAndConquer(length, 0, 0);
    }

    private static void divideAndConquer(int size, int curX, int curY) {
        if (curX == r && curY == c) {
            System.out.println(cnt);
            return;
        }

        if (r < curX + size && r >= curX && c < curY + size && c >= curY) {
            divideAndConquer(size / 2, curX, curY);
            divideAndConquer(size / 2, curX, curY + size / 2);
            divideAndConquer(size / 2, curX + size / 2, curY);
            divideAndConquer(size / 2, curX + size / 2, curY + size / 2);
        } else {
            cnt += size * size;
        }
    }
}
