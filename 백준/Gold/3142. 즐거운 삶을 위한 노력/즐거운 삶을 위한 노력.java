import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] primeNumber = new boolean[1000001];
    static int[] primeNumberCount = new int[1000001];
    static boolean[] primeFactor = new boolean[1000001];

    static List<Integer> primeNumbers = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (!primeNumber[i]) {
                for (int j = 2; i * j <= 1000000; j++) {
                    primeNumber[i * j] = true;
                }
            }
        }

        for (int i = 2; i <= 1000; i++) {
            if (!primeNumber[i]) {
                primeNumbers.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            for (Integer primeNum : primeNumbers) {
                if (number == 1) {
                    break;
                }

                if (!primeNumber[number]) {
                    cnt += primeFactor[number] ? -1 : 1;
                    primeFactor[number] = !primeFactor[number];
                    break;
                }

                while (number % primeNum == 0) {
                    number /= primeNum;
                    cnt += primeFactor[primeNum] ? -1 : 1;
                    primeFactor[primeNum] = !primeFactor[primeNum];
                }
            }

            if (cnt == 0) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb);
    }
}
