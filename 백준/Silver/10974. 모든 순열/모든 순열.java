import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] check;
    static int[] newArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        newArr = new int[n + 1];
        arr = new int[n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        rec(0, arr, check, 0);
    }


    private static void rec(int pos, int[] arr, boolean[] check, int size) {
        if (size == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(newArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                newArr[pos] = arr[i];
                rec(pos + 1, arr, check, size + 1);
                check[i] = false;
            }
        }
    }
}
