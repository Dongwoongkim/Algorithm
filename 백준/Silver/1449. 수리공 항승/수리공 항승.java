import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        List<Integer> difference = new ArrayList<>();

        int l = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n);

        for (int i = 1; i < n; i++) {
            difference.add(arr[i] - arr[i - 1]);
        }

        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < difference.size(); i++) {
            sum += difference.get(i);
            if (sum >= l) {
                sum = 0;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
