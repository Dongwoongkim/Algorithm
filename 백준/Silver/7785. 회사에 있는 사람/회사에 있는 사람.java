import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> map = new HashMap<>();
        addOrRemove(n, br, map);

        List<String> answer = map.keySet().stream().map(String::new).collect(Collectors.toList());
        
        printAnswer(answer);
    }

    private static void addOrRemove(int n, BufferedReader br, Map<String, Integer> map) throws IOException {
        for (int i = 0; i < n; i++) {
            List<String> collect = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());

            if (map.containsKey(collect.get(0)) && collect.get(1).equals("leave")) {
                map.remove(collect.get(0));
            }

            if (!map.containsKey(collect.get(0)) && collect.get(1).equals("enter")) {
                map.put(collect.get(0), 1);
            }
        }
    }

    private static void printAnswer(List<String> answer) {
        sort(answer);
        Collections.reverse(answer);

        for (String people : answer) {
            System.out.println(people);
        }
    }
}
