import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] ability;
    static int n;
    static boolean[] check;
    static int[] tmp;
    static List<Integer> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        tmp = new int[n / 2 + 1];
        arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ability[i][j] = sc.nextInt();
            }
        }

        rec(0, 0);

        int answer = 1001;

        for (int i = 0; i <= (arr.size()) / 2 - 1; i++) {
            answer = Math.min(answer, Math.abs(arr.get(arr.size() - 1 - i) - arr.get(i)));
        }

        System.out.println(answer);
    }

    private static void rec(int pos, int previous) {
        if (pos == n / 2) {
            int score = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    score += ability[tmp[i]][tmp[j]] + ability[tmp[j]][tmp[i]];
                }
            }
            arr.add(score);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == false && previous < i) {
                check[i] = true;
                tmp[pos] = i;
                rec(pos + 1, tmp[pos]);
                check[i] = false;
            }
        }
    }
}
