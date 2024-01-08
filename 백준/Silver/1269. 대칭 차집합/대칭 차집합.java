import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> a = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> b = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        sort(a);
        sort(b);

        int answer = getAnswer(b, a, 0);
        System.out.println(answer);
    }

    private static int getAnswer(List<Integer> b, List<Integer> a, int cnt) {
        for (int i = 0; i < b.size(); i++) {
            if (0 > binarySearch(a, b.get(i))) {
                cnt++;
            }
        }

        for (int i = 0; i < a.size(); i++) {
            if (0 > binarySearch(b, a.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }
}
