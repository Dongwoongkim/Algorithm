import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, List<Integer>> point = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (point.get(x) == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(y);
                point.put(x, tmp);
                continue;
            }

            List<Integer> yList = point.get(x);
            yList.add(y);
            point.put(x, yList);
        }

        for (Integer i : point.keySet()) {
            sort(point.get(i));
        }
        
        List<Integer> keyList = new ArrayList<>(point.keySet());
        sort(keyList);

        for (Integer x : keyList) {
            List<Integer> yList = point.get(x);
            for (Integer y : yList) {
                System.out.println(x + " " + y);
            }
        }
    }
}
