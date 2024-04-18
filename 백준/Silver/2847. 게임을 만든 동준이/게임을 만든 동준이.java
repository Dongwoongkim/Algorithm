import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(i + 1)) {
                cnt += arr.get(i) - arr.get(i + 1) + 1;
                arr.set(i, arr.get(i + 1) - 1);
            }
        }

        System.out.println(cnt);
    }
}
