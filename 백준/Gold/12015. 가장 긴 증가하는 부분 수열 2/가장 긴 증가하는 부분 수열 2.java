import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static List<Integer> increase = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        increase.add(arr[0]);
        for (int i = 1; i < n; i++) {
            int searchNum = arr[i];

            if (searchNum > increase.get(increase.size() - 1)) {
                increase.add(arr[i]);
            } else {
                replace(searchNum, increase);
            }
        }

        System.out.println(increase.size());
    }

    private static void replace(int searchNum, List<Integer> increase) {
        int start = 0;
        int end = increase.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int middleNum = increase.get(mid);

            if (middleNum < searchNum) {
                start = mid + 1;
            }
            if (middleNum >= searchNum) {
                end = mid;
            }
        }

        increase.set(start, searchNum);
    }
}
