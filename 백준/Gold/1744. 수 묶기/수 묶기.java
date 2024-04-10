import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] arr;

    static List<Integer> negative = new ArrayList<>();
    static List<Integer> positive = new ArrayList<>();
    static int zeroCnt = 0;
    static int oneCnt = 0;

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negative.add(arr[i]);
            }
            if (arr[i] == 0) {
                zeroCnt++;
                continue;
            }
            if (arr[i] == 1) {
                oneCnt++;
                continue;
            }

            if (arr[i] > 1) {
                positive.add(arr[i]);
            }
        }

        Collections.sort(negative);
        Collections.sort(positive);

        Collections.reverse(positive);

        if (negative.size() % 2 == 0) {
            for (int i = 0; i < negative.size(); i += 2) {
                ans += negative.get(i) * negative.get(i + 1);
            }
        } else if (negative.size() % 2 == 1) {
            for (int i = 0; i < negative.size() - 1; i += 2) {
                ans += negative.get(i) * negative.get(i + 1);
            }

            if (zeroCnt == 0) {
                oneCnt--;
                ans += negative.get(negative.size() - 1) + 1;
            }
        }

        ans += (oneCnt) * 1;

        if (positive.size() % 2 == 0) {
            for (int i = 0; i < positive.size(); i += 2) {
                ans += positive.get(i) * positive.get(i + 1);
            }
        } else if (positive.size() % 2 == 1) {
            for (int i = 0; i < positive.size() - 1; i += 2) {
                ans += positive.get(i) * positive.get(i + 1);
            }

            ans += positive.get(positive.size() - 1);
        }

        System.out.println(ans);

    }
}
