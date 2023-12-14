import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                arr.add(sc.nextInt());
            }
            a.add(arr);
        }

        int maxValue = -1;
        int col = 0;
        int row = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a.get(i).get(j) > maxValue) {
                    maxValue = a.get(i).get(j);
                    col = i + 1;
                    row = j + 1;
                }
            }
        }
        System.out.println(maxValue);
        System.out.print(col + " " + row);
    }
}
