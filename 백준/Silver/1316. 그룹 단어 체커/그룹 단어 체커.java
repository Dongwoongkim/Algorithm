import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            answer += check(line);
        }

        System.out.print(answer);
    }

    private static int check(String line) {
        Map<Character, Boolean> map = new HashMap<>();

        for (int start = 0; start < line.length(); start++) {

            for (int next = start + 1; next < line.length(); next++) {
                if (line.charAt(start) != line.charAt(next)) {
                    start = next - 1;
                    break;
                }
                start++;
            }

            if (map.get(line.charAt(start)) == null) {
                map.put(line.charAt(start), true);
                continue;
            }

            if (map.get(line.charAt(start)) == true) {
                return 0;
            }
        }
        return 1;
    }
}
