import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(sc.nextInt());
        }
        
        System.out.println(getAnswer(n, cards, m));
    }

    private static int getAnswer(int n, List<Integer> cards, int m) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards.get(i) + cards.get(j) + cards.get(k);
                    if (sum <= m) {
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        return ans;
    }
}
