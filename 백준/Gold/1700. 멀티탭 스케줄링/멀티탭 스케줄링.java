import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static int[] frequency;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int cnt = 0;

        List<Integer> pN = new ArrayList<>();
        List<Integer> plug = new ArrayList<>();
        frequency = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            pN.add(num);
        }

        for (int i = 0; i < k; i++) {
            // 꼽혀있는 경우
            if (plug.contains(pN.get(i))) {
                continue;
            }

            // 꼽혀있지 않고 콘센트에 자리가 있는 경우
            if (plug.size() < n) {
                plug.add(pN.get(i));
                continue;
            }

            // 꼽혀있지 않고 콘센트에 자리가 없는 경우

            int removeIdx = -1;
            int pos = -1;
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int l = i + 1; l < k; l++) {
                    if (plug.get(j) == pN.get(l)) {
                        break;
                    }
                    tmp++;
                }

                if (tmp > removeIdx) {
                    pos = j;
                    removeIdx = tmp;
                }
            }

            plug.set(pos, pN.get(i));
            cnt++;
        }

        System.out.println(cnt);
    }
}
