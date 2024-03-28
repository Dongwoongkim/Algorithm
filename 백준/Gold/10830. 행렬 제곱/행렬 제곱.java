import java.util.Scanner;

public class Main {

    static int n;
    static long m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextLong();

        int[][] A = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int[][] c = pow(A, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }

    private static int[][] pow(int[][] a, long exponent) {
        if (exponent == 1) {
            return a;
        }

        int[][] tmp = pow(a, exponent / 2);

        if (exponent % 2 == 1) {
            return getAnswer(a, (getAnswer(tmp, tmp)));
        }

        return getAnswer(tmp, tmp);
    }

    private static int[][] getAnswer(int[][] tmp, int[][] tmp1) {
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    arr[i][j] += (tmp[i][l] * tmp1[l][j]) % 1000;
                }
            }
        }

        return arr;
    }
}
