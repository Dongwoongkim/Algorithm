import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;

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

        List<Integer> nm = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = nm.get(0);
        int m = nm.get(1);

        int answer = 0;
        List<String> nStrings = new ArrayList<>();
        List<String> mStrings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nStrings.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            mStrings.add(br.readLine());
        }

        sort(nStrings);

        answer = getAnswer(m, nStrings, mStrings, answer);
        printAswer(answer);
    }

    private static void printAswer(int answer) {
        System.out.println(answer);
    }

    private static int getAnswer(int m, List<String> nStrings, List<String> mStrings, int answer) {
        for (int i = 0; i < m; i++) {
            int idx = binarySearch(nStrings, mStrings.get(i));
            answer += idx >= 0 ? 1 : 0;
        }
        return answer;
    }
}
