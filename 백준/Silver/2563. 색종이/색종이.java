import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> paper = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            List<Integer> row = new ArrayList<>(100);
            for (int j = 0; j < 100; j++) {
                row.add(0);
            }
            paper.add(row);
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int p = x; p < x + 10; p++) {
                for (int q = y; q < y + 10; q++) {
                    paper.get(p).set(q, 1);
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper.get(i).get(j) == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}
