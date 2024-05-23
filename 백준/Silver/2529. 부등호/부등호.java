import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static String strMin;
    static String strMax;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static int n;
    static boolean[] visited = new boolean[10];
    static List<String> func = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        func = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());

        rec(0, "");

        System.out.println(strMax);
        System.out.println(strMin);
    }

    private static void rec(int cnt, String line) {
        if (cnt >= 2 && func.get(cnt - 2).equals("<")) {
            if (line.charAt(cnt - 2) >= line.charAt(cnt - 1)) {
                return;
            }
        }

        if (cnt >= 2 && func.get(cnt - 2).equals(">")) {
            if (line.charAt(cnt - 2) <= line.charAt(cnt - 1)) {
                return;
            }
        }

        if (cnt == n + 1) {
            long value = Long.parseLong(line);
            if (value < min) {
                min = value;
                strMin = line;
            }
            if (value > max) {
                max = value;
                strMax = line;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                rec(cnt + 1, line + i);
                visited[i] = false;
            }
        }
    }
}
