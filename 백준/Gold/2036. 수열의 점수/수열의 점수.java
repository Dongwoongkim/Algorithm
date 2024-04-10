import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static long[] arr;
    static List<Long> negative = new ArrayList<>();
    static List<Long> positive = new ArrayList<>();
    static int zeroCnt = 0;
    static int oneCnt = 0;
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new long[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
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

        for (int i = 0; i < negative.size() - 1; i += 2) {
            ans += negative.get(i) * negative.get(i + 1);
        }

        if (negative.size() % 2 == 1) {
            // 0이 없고 1만 있는 경우
            if (zeroCnt == 0 && oneCnt >= 1) {
                oneCnt--;
                ans += negative.get(negative.size() - 1) + 1;
                // 0도 없고 1도 없는 경우
            } else if (zeroCnt == 0 && oneCnt == 0) {
                // 어쩔수없다 음수지만 그냥 더해
                ans += negative.get(negative.size() - 1);
            }
        }

        if (oneCnt >= 1) {
            ans += (oneCnt) * 1;
        }

        for (int i = 0; i < positive.size() - 1; i += 2) {
            ans += positive.get(i) * positive.get(i + 1);
        }

        if (positive.size() % 2 == 1) {
            ans += positive.get(positive.size() - 1);
        }

        System.out.println(ans);
    }
}
