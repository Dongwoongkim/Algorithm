import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int size = sc.nextInt();

            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                arr.add(sc.nextInt());
            }

            Collections.sort(arr);

            int[] ans = new int[size + 1];

            int k = 0;
            for (int j = 0; j < size / 2; j++) {
                ans[j] = arr.get(k);
                ans[size - j - 1] = arr.get(k + 1);
                k += 2;
            }

            if (size % 2 == 1) {
                ans[size / 2] = arr.get(size - 1);
            }

            int difficult = -1;
            for (int j = 1; j < size; j++) {
                difficult = Math.max(difficult, Math.abs(ans[j] - ans[j - 1]));
            }

            difficult = Math.max(difficult, Math.abs(ans[size - 1] - ans[0]));

            System.out.println(difficult);
        }
    }
}
