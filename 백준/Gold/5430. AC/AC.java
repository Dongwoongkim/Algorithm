import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static int t;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            List<Integer> numbers;

            if (input.equals("[]")) {
                numbers = new ArrayList<>();
            } else {
                numbers = Arrays.stream(
                        input.replaceAll("[\\[\\]\\s]", "").split(",")
                    )
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            }

            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                dq.add(numbers.get(j));
            }

            boolean reverse = true;
            boolean error = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    if (reverse) {
                        reverse = false;
                    } else {
                        reverse = true;
                    }
                }

                if (p.charAt(j) == 'D') {
                    boolean delete = delete(dq, reverse);

                    if (!delete) {
                        error = true;
                        break;
                    }
                }
            }

            if (error) {
                sb.append("error").append("\n");
            } else {
                String result;

                if (reverse) {
                    List<Integer> list = new ArrayList<>(dq);

                    result = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]"));

                    sb.append(result).append("\n");
                } else {
                    List<Integer> list = new ArrayList<>(dq);
                    Collections.reverse(list);

                    result = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]"));

                    sb.append(result).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean delete(Deque<Integer> dq, boolean reverse) {
        if (dq.isEmpty()) {
            return false;
        }

        if (reverse) {
            dq.pollFirst();
        } else {
            dq.pollLast();
        }

        return true;
    }
}
