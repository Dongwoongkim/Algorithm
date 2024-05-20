import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean[] check = new boolean[10001];
    static int sum = 0;
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 100; i++) {
            check[i * i] = true;
        }
        for (int i = n; i <= m; i++) {
            if (check[i] == true) {
                sum += i;
                arr.add(i);
            }
        }

        if (arr.isEmpty()) {
            System.out.println(-1);
            return;
        }

        System.out.println(arr.stream().mapToInt(value -> value.intValue()).sum());
        System.out.println(arr.get(0));

    }
}
