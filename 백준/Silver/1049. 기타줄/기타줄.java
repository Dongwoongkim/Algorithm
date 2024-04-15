import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Guitar> guitars = new ArrayList<>();

        int minOne = 1001;
        for (int i = 0; i < m; i++) {
            int six = sc.nextInt();
            int one = sc.nextInt();

            minOne = Math.min(one, minOne);

            guitars.add(new Guitar(six, one));
        }

        Collections.sort(guitars);

        int ans = 0;
        if (n < 6) {
            ans = guitars.get(0).sixPrice;
        } else {
            ans += (n / 6) * guitars.get(0).sixPrice;
        }

        ans += Math.min((n % 6) * minOne, guitars.get(0).sixPrice);
        System.out.println(Math.min(minOne * n, ans));
    }

    static class Guitar implements Comparable<Guitar> {

        int sixPrice;
        int onePrice;

        public Guitar(int sixPrice, int onePrice) {
            this.sixPrice = sixPrice;
            this.onePrice = onePrice;
        }

        @Override
        public int compareTo(Guitar o) {
            return Integer.compare(this.sixPrice, o.sixPrice);
        }
    }
}
