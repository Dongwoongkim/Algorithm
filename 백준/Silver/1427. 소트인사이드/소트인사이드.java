import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        addInArray(n, arr);

        sort(arr, Collections.reverseOrder());

        arr.stream().forEach(number -> System.out.print(number));
    }

    private static void addInArray(int n, List<Integer> arr) {
        while (true) {
            if (n == 0) {
                break;
            }
            arr.add(n % 10);
            n /= 10;
        }
    }
}
