import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }

        Collections.sort(arr);
        System.out.println(sum - arr.get(arr.size() - 1));
    }
}
