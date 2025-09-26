import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static List<Integer> difficulty = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        int k = Math.toIntExact(Math.round(n * 0.15));
        long sum = 0;

        for (int i = k; i < n - k; i++) {
            sum += difficulty.get(i);
        }
        System.out.println(Math.round((double) sum / (n - k * 2)));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            difficulty.add(Integer.parseInt(br.readLine()));
        }
        difficulty.sort(Integer::compareTo);
    }
}
