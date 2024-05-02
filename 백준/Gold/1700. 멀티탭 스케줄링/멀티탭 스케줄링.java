import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int k;
    static int use = 0;
    static int cnt = 0;
    static List<Integer> p = new ArrayList<>();
    static List<Integer> outlet = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            p.add(num);
        }

        for (int i = 0; i < k; i++) {
            if (outlet.contains(p.get(i))) {
                continue;
            }

            if (use < n) {
                use++;
                outlet.add(p.get(i));
                continue;
            }

            if (use == n) {
                int pos = -1; // 멀티탭에서 뺄 자리
                int idx = -1; // 스케줄에서 가장 마지막에 잡혀있는 것
                for (int l = 0; l < n; l++) {
                    int tmp = 0;
                    for (int j = i + 1; j < k; j++) {
                        if (outlet.get(l) == p.get(j)) {
                            break;
                        }
                        tmp++;
                    }
                    if (tmp > idx) {
                        pos = l;
                        idx = tmp;
                    }
                }

                outlet.set(pos, p.get(i));
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
