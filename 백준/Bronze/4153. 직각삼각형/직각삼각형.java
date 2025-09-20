import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            List<Integer> list = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            if (list.get(0) == 0 && list.get(1) == 0 && list.get(2) == 0) {
                break;
            }

            getAnswer(list);
        }

        System.out.print(sb);
    }

    private static void getAnswer(List<Integer> list) {
        list.sort(Comparator.reverseOrder());

        if (list.get(0) * list.get(0) == list.get(1) * list.get(1) + list.get(2) * list.get(2)) {
            sb.append("right").append("\n");
        } else {
            sb.append("wrong").append("\n");
        }
    }
}
