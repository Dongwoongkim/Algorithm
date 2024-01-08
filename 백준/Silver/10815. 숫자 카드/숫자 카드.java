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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> cards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int m = Integer.parseInt(br.readLine());

        List<Integer> answer = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        sort(cards);

        for (int i = 0; i < answer.size(); i++) {
            Integer card = answer.get(i);

            int idx = binarySearch(cards, card);

            if (idx >= 0) {
                sb.append(1).append(" ");
                continue;
            }

            sb.append(0).append(" ");
        }

        System.out.print(sb);
    }
}
