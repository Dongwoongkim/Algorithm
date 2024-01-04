import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNumerator(n) + "/" + getDenominator(n));
    }

    private static Integer getNumerator(int n) {
        return getElement(n, 1, 1, 1);
    }

    private static Integer getDenominator(int n) {
        return getElement(n, 1, 2, 1);
    }

    private static int getElement(int n, int idx, int cnt, int ans) {
        while (idx <= n) {
            for (int i = 1; i <= cnt; i++) {
                ans = i;
                if (idx == n) {
                    return ans;
                }
                idx++;
            }

            for (int i = cnt - 1; i >= 1; i--) {
                ans = i;
                if (idx == n) {
                    return ans;
                }
                idx++;
            }

            cnt += 2;
        }

        return ans;
    }
}
