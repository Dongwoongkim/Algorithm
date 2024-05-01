import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> crain = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            crain.add(sc.nextInt());
        }
        Collections.sort(crain);
        Collections.reverse(crain);

        int m = sc.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(sc.nextInt());
        }
        Collections.sort(boxes);
        Collections.reverse(boxes);

        if (boxes.get(0) > crain.get(0)) {
            System.out.println(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            cnt++;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (idx == boxes.size()) {
                    break;
                }

                if (crain.get(i) >= boxes.get(idx)) {
                    boxes.remove(idx);
                    continue;
                }

                idx++;
                i--;

            }
        }

        System.out.println(cnt);
    }
}
