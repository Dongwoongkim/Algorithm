import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Number> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(new Number(Long.parseLong(st.nextToken())));
        }

        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr.get(i).num + " ");
        }
        System.out.print(sb);
    }

    static class Number implements Comparable<Number> {
        long num;
        int two;
        int three;

        public Number(long num) {
            this.num = num;
            this.three = getThreeCnt(num);
            this.two = getTwoCnt(num);
        }

        private int getTwoCnt(long k) {
            int twoCnt = 0;

            while (k % 2 == 0) {
                twoCnt++;
                k /= 2;
            }

            return twoCnt;
        }

        private int getThreeCnt(long k) {
            int threeCnt = 0;

            while (k % 3 == 0) {
                threeCnt++;
                k /= 3;
            }

            return threeCnt;
        }

        @Override
        public int compareTo(Number o) {
            if (o.three == this.three) {
                return Integer.compare(this.two, o.two);
            }

            return Integer.compare(o.three, this.three);
        }
    }
}
