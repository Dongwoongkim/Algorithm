import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static String eq;
    static List<String> splitMinus = new ArrayList<>();
    static List<Integer> numbers = new ArrayList<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eq = br.readLine();

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        splitMinus = Arrays.stream(eq.split("-"))
            .collect(Collectors.toList());

        for (String minus : splitMinus) {
            if (minus.contains("+")) {
                int sum = Arrays.stream(minus.split("\\+"))
                    .mapToInt(Integer::parseInt).sum();
                numbers.add(sum);
            } else {
                numbers.add(Integer.parseInt(minus));
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                ans += numbers.get(i);
                continue;
            }
            ans -= numbers.get(i);
        }

        return ans;
    }
}
