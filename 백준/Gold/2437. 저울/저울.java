import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        int sum = 1;
        for (int i = 0; i < n; i++) {
            if (sum < arr.get(i)) {
                break;
            }
            sum += arr.get(i);
        }
        System.out.println(sum);
    }
}
