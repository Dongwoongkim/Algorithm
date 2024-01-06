import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arr.add(sc.nextInt());
        }

        sortArr(arr);
        printAnswer(arr);
    }

    private static void sortArr(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    private static void printAnswer(List<Integer> arr) {
        System.out.println((int) arr.stream().mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println(arr.get(arr.size() / 2));
    }
}
