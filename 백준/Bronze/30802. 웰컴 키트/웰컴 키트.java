import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, t, p;
    static List<Integer> clothes = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < 6; i++) {
            int clothe = clothes.get(i);

            if (clothe % t != 0) {
                cnt += (clothe / t) + 1;
            } else {
                cnt += clothe / t;
            }
        }

        System.out.println(cnt);
        System.out.print((n / p) + " " + (n % p));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            clothes.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
    }
}
