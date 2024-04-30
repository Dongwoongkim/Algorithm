import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] check = new boolean[1001];

        List<Subject> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int w = sc.nextInt();

            arr.add(new Subject(d, w));
        }

        Collections.sort(arr);

        int ans = 0;
        for (Subject subject : arr) {
            if (check[subject.due] == false) {
                check[subject.due] = true;
                ans += subject.score;
                continue;
            }
            if (check[subject.due] == true) {
                int prev = subject.due - 1;

                while (prev > 0) {
                    if (check[prev] == false) {
                        check[prev] = true;
                        ans += subject.score;
                        break;
                    }
                    prev--;
                }
            }
        }

        System.out.println(ans);
    }

    static class Subject implements Comparable<Subject> {
        int due;
        int score;

        public Subject(int due, int score) {
            this.due = due;
            this.score = score;
        }

        @Override
        public int compareTo(Subject o) {
            return Integer.compare(o.score, this.score);
        }
    }
}
