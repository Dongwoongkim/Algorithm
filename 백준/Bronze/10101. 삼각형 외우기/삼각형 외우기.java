import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(getAnswer(arr));
    }

    private static String getAnswer(List<Integer> arr) {
        if (arr.stream().mapToInt(Integer::intValue).sum() != 180) {
            return "Error";
        }

        if (arr.stream().distinct().count() == 3) {
            return "Scalene";
        }

        if (arr.stream().distinct().count() == 2) {
            return "Isosceles";
        }

        return "Equilateral";
    }
}
