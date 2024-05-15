import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rank = new int[n + 1];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
        }

        List<Dungchi> dungchis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int kg = sc.nextInt();
            int height = sc.nextInt();
            dungchis.add(new Dungchi(kg, height));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                Dungchi a = dungchis.get(i);
                Dungchi b = dungchis.get(j);
                if (a.height < b.height && a.kg < b.kg) {
                    rank[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(rank[i] + " ");
        }
    }

    static class Dungchi {
        int kg;
        int height;

        public Dungchi(int kg, int height) {
            this.kg = kg;
            this.height = height;
        }
    }
}
