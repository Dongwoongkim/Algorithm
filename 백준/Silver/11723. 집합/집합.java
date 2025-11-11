import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static boolean[] set = new boolean[21];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set[j] = true;
                }
                continue;
            }

            if (command.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    set[j] = false;
                }
                continue;
            }

            int number = Integer.parseInt(st.nextToken());

            if (command.equals("add")) {
                set[number] = true;
            }

            if (command.equals("remove")) {
                set[number] = false;
            }

            if (command.equals("check")) {
                if (set[number]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }

            if (command.equals("toggle")) {
                set[number] = !set[number];
            }
        }

        System.out.print(sb);
    }
}
