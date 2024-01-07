import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> members = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> info = Arrays.stream(br.readLine()
                    .split(" ")).collect(Collectors.toList());
            addToMap(info, members);
        }

        List<Integer> ages = sortByAge(members);
        printAnswer(ages, members);
    }

    private static List<Integer> sortByAge(Map<Integer, List<String>> members) {
        List<Integer> ages = members.keySet()
                .stream()
                .collect(Collectors.toList());
        sort(ages);
        return ages;
    }

    private static void addToMap(List<String> info, Map<Integer, List<String>> members) {
        Integer age = Integer.valueOf(info.get(0));
        String name = info.get(1);

        List<String> names = members.get(age);

        if (names == null) {
            List<String> values = new ArrayList<>();
            values.add(name);
            members.put(age, values);
            return;
        }

        names.add(name);
        members.put(age, names);
    }

    private static void printAnswer(List<Integer> ages, Map<Integer, List<String>> members) {
        for (Integer age : ages) {
            List<String> names = members.get(age);
            for (String name : names) {
                System.out.println(age + " " + name);
            }
        }
    }

}
