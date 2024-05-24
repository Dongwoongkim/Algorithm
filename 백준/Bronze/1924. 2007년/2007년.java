import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int day = 0;
        for (int month = 1; month <= x - 1; month++) {
            if (thirtyOne(month)) {
                day += 31;
                continue;
            }

            if (thirty(month)) {
                day += 30;
                continue;
            }

            day += 28;
        }

        day += y;

        System.out.println(days[day % 7]);
    }

    private static boolean thirtyOne(int x) {
        return x == 1 || x == 3 || x == 5 || x == 7 || x == 8 || x == 10 || x == 12;
    }

    private static boolean thirty(int x) {
        return x == 4 || x == 6 || x == 9 || x == 11;
    }
}
