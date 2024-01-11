import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            List<Integer> arr = new ArrayList<>();
            arr.add(a);
            arr.add(b);
            arr.add(c);

            System.out.println(getAnswer(arr));
        }

    }

    private static String getAnswer(List<Integer> arr) {
        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (max <= arr.get(i)) {
                maxIdx = i;
                max = arr.get(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i != maxIdx) {
                sum += arr.get(i);
            }
        }

        if (sum <= max) {
            return "Invalid";
        }

        if (arr.stream().distinct().count() == 2) {
            return "Isosceles";
        }

        if (arr.stream().distinct().count() == 1) {
            return "Equilateral";
        }

        return "Scalene";
    }
}
