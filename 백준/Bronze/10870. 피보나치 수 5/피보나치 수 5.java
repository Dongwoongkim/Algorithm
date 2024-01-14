import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        arr.add(0);
        arr.add(1);

        for (int i = 2; i <= n; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }
        System.out.println(arr.get(n));
    }
}
