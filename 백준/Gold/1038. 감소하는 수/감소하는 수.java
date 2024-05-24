import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(bfs(n));
    }

    private static String bfs(int n) {
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
                int num = s.charAt(s.length() - 1) - '0';
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
}

