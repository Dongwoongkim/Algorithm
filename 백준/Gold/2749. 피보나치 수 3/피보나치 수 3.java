import java.util.Scanner;

public class Main {

    static long[][] a = {{1, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[][] powMatrix = getPow(a, n);

        System.out.println(powMatrix[1][0] % 1000000);
    }

    private static long[][] getPow(long[][] a, long size) {
        if (size == 1) {
            return a;
        }

        long newSize = size / 2;

        long[][] tmp = getPow(a, newSize);

        if (size % 2 == 1) {
            return getMultiply(a, getMultiply(tmp, tmp));
        }

        return getMultiply(tmp, tmp);
    }

    private static long[][] getMultiply(long[][] tmp, long[][] tmp2) {
        long[][] arr = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    arr[i][j] += (tmp[i][k] * tmp2[k][j]) % 1000000;
                }
            }
        }
        return arr;
    }
}
