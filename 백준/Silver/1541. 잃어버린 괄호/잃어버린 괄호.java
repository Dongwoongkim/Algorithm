import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        List<String> subEq = Arrays.stream(line.split("-")).collect(Collectors.toList());

        List<Integer> numbers = new ArrayList<>();
        for (String s : subEq) {
            int sum = Arrays.stream(s.split("\\+")).mapToInt(Integer::parseInt).sum();
            numbers.add(sum);
        }

        int ans = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            ans -= numbers.get(i);
        }
        System.out.println(ans);
    }
}
