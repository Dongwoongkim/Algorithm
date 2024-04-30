import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextLong());
        }

        Collections.sort(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs((i + 1) - arr.get(i));
        }

        System.out.println(ans);

    }
}
