import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            printAnswer(n);
        }
    }

    private static void printAnswer(int n) {
        if (isPerfectNumber(n)) {
            System.out.println(n + " = " + getElement(n));
            return;
        }
        System.out.println(n + " is NOT perfect.");
    }

    private static String getElement(int n) {
        List<Integer> arr = getAliquotExcludeN(n);
        return arr.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
    }

    private static List<Integer> getAliquotExcludeN(int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                arr.add(i);
            }
        }
        return arr;
    }

    private static boolean isPerfectNumber(int n) {
        List<Integer> arr = getAliquotExcludeN(n);

        int sum = arr.stream().mapToInt(Integer::intValue).sum();
        if (n == sum) {
            return true;
        }
        return false;
    }
}
