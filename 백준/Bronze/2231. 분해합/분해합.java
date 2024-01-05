import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();

        int n = sc.nextInt();

        for (int number = 1; number <= n; number++) {
            int sumOfEachNum = getSumOfEachNumber(number);
            map.put(number, number + sumOfEachNum);
        }

        printAnswer(n, map);
    }

    private static void printAnswer(int n, Map<Integer, Integer> map) {
        for (int number = 1; number <= n; number++) {
            if (map.get(number).equals(n)) {
                System.out.println(number);
                return;
            }
        }

        System.out.println(0);
    }

    private static int getSumOfEachNumber(int number) {
        int sum = 0;
        while (true) {
            if (number == 0) {
                break;
            }
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
