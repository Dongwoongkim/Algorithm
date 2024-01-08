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
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        List<Integer> numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Integer n = numbers.get(0);
        Integer m = numbers.get(1);

        List<String> notListened = new ArrayList<>();
        List<String> notSeen = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            notListened.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            notSeen.add(br.readLine());
        }

        sort(notListened);

        List<String> answer = new ArrayList<>();
        for (String name : notSeen) {
            if (0 <= binarySearch(notListened, name)) {
                answer.add(name);
            }
        }

        sort(answer);

        System.out.println(answer.size());
        answer.stream().forEach(name -> System.out.println(name));
    }
}
