import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> primeNumbers = new ArrayList<>();
    static boolean isPrime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }

        int left, right;
        right = left = 0;

        int sum = 0;
        int cnt = 0;

        while (left < primeNumbers.size() && right < primeNumbers.size()) {
            if (sum < n) {
                sum += primeNumbers.get(right);
                right++;
            } else if (sum >= n) {
                if (sum == n) {
                    cnt++;
                }
                sum -= primeNumbers.get(left);
                left++;
            }
        }

        if (isPrime[n]) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
