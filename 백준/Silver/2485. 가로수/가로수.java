import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        for (int i = 1; i < n; i++) {
            arr2.add(arr.get(i) - arr.get(i - 1));
        }

        int k = arr2.get(0);

        for (int i = 1; i < arr2.size(); i++) {
            k = gcd(k, arr2.get(i));
        }

        System.out.println((arr.get(n - 1) - arr.get(0)) / k + 1 - n);
    }


    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
