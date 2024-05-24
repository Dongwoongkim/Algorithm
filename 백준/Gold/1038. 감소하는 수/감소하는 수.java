import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int cnt = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i <= 9; i++) {
            if (cnt == n) {
                return String.valueOf(i);
            }
            queue.add(String.valueOf(i));
            cnt++;
        }

        while (!queue.isEmpty()) {
            String s = queue.poll();

            for (int i = 0; i <= 9; i++) {
                int num = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
                if (num > i) {
                    queue.add(s + i);
                    if (cnt == n) {
                        return s + i;
                    }
                    cnt++;
                }
            }
        }

        return String.valueOf(-1);
    }

    private static boolean check(String k) {
        for (int i = 0; i < k.length() - 1; i++) {
            if (k.charAt(i) <= k.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }
}

