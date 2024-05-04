import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int cur = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == cur % 3) {
                cur++;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
