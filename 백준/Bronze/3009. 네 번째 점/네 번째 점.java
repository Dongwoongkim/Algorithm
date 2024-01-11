import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();

            if (!xMap.containsKey(x1)) {
                xMap.put(x1, 0);
            }
            if (!yMap.containsKey(y1)) {
                yMap.put(y1, 0);
            }

            xMap.put(x1, xMap.get(x1) + 1);
            yMap.put(y1, yMap.get(y1) + 1);
        }

        for (Integer i : xMap.keySet()) {
            if (xMap.get(i).equals(1)) {
                System.out.print(i + " ");
            }
        }

        for (Integer i : yMap.keySet()) {
            if (yMap.get(i).equals(1)) {
                System.out.print(i);
            }
        }
    }
}
