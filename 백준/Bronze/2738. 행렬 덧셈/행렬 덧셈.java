import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                arr.add(sc.nextInt());
            }
            a.add(arr);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                arr.add(sc.nextInt());
            }
            b.add(arr);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a.get(i).get(j) + b.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
