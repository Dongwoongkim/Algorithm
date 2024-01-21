import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static int n;
    static int[] arr;
    static int[] operator;
    static int[] operatorCom;
    static int[] tmp;
    static boolean[] check;
    static int cnt = 0;
    static LinkedHashSet<String> dict;
    static int maxAns = -1_000_000_000;
    static int minAns = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        operator = new int[4];
        operatorCom = new int[n - 1];
        tmp = new int[n - 1];
        check = new boolean[n - 1];
        dict = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int num = operator[i];
            for (int j = 0; j < num; j++) {
                operatorCom[idx] = i;
                idx++;
            }
        }

        rec(0, n - 1);
        System.out.println(maxAns);
        System.out.println(minAns);
    }


    private static void rec(int pos, int m) {
        if (pos == m) {
            String ans = "";
            for (int i = 0; i < m; i++) {
                ans += tmp[i] + " ";
            }

            if (!dict.contains(ans)) {
                dict.add(ans);
                List<Integer> operators = Arrays.stream(ans.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                int answer = getAnswer(operators);

                minAns = Math.min(answer, minAns);
                maxAns = Math.max(answer, maxAns);
            }

            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (check[i] == false) {
                check[i] = true;
                tmp[pos] = operatorCom[i];
                rec(pos + 1, m);
                check[i] = false;
            }
        }

    }

    private static int getAnswer(List<Integer> operators) {
        int ans = arr[0];

        for (int i = 0; i < n - 1; i++) {
            if (operators.get(i) == 0) {
                ans += arr[i + 1];
                continue;
            }

            if (operators.get(i) == 1) {
                ans -= arr[i + 1];
                continue;
            }

            if (operators.get(i) == 2) {
                ans *= arr[i + 1];
                continue;
            }

            if (operators.get(i) == 3) {
                if (ans < 0) {
                    ans *= -1;
                    ans /= arr[i + 1];
                    ans *= -1;
                    continue;
                }

                if (ans > 0) {
                    ans /= arr[i + 1];
                }
            }
        }

        return ans;
    }
}
