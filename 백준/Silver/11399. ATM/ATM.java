import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Atm> atms = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            atms.add(new Atm(i, sc.nextInt()));
        }

        Collections.sort(atms);

        int ans = 0;

        for (int i = 1; i < n; i++) {
            atms.get(i).time += atms.get(i - 1).time;
            ans += atms.get(i).time;
        }

        System.out.println(ans + atms.get(0).time);
    }

    static class Atm implements Comparable<Atm> {
        int idx;
        int time;

        public Atm(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Atm o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
