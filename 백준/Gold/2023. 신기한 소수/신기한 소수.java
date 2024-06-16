import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prime = {2, 3, 5, 7};

        for (int i = 0; i < prime.length; i++) {
            dfs(prime[i], 1, n);
        }

    }

    private static void dfs(int cur, int cnt, int n) {
        if (cnt == n) {
            System.out.println(cur);
        }

        for (int i = 1; i <= 9; i += 2) {
            if (check(cur * 10 + i)) {
                dfs(cur * 10 + i, cnt + 1, n);
            }
        }
    }

    private static boolean check(int number) {
        while (true) {
            if (number == 0) {
                break;
            }

            if (number == 1) {
                return false;
            }

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }

            number /= 10;
        }

        return true;
    }
}

