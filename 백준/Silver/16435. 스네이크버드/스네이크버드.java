import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] h = new int[n + 1];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        Arrays.sort(h, 0, n);

        for (int i = 0; i < n; i++) {
            if (h[i] <= l) {
                l += 1;
            }
        }

        System.out.println(l);
    }
}
