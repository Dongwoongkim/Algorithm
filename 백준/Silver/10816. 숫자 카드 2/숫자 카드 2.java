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
            sb.append(upperBinarySearch(cards, card) - lowerBinarySearch(cards, card)).append(" ");
        }

        System.out.print(sb);
    }

    private static int upperBinarySearch(List<Integer> cards, Integer card) {
        int start = 0;
        int end = cards.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (cards.get(mid) <= card) {
                start = mid + 1;
                continue;
            }

            end = mid;
        }
        return end;
    }

    private static int lowerBinarySearch(List<Integer> cards, Integer card) {
        int start = 0;
        int end = cards.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (cards.get(mid) >= card) {
                end = mid;
                continue;
            }

            start = mid + 1;
        }
        return end;
    }
}
