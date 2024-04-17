import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> censor = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            censor.add(sc.nextInt());
        }

        Collections.sort(censor);

        List<Integer> difference = new ArrayList<>();

        for (int i = 1; i < censor.size(); i++) {
            difference.add(censor.get(i) - censor.get(i - 1));
        }

        Collections.sort(difference);
        Collections.reverse(difference);

        long ans = 0;
        for (int i = k - 1; i < difference.size(); i++) {
            ans += difference.get(i);
        }
        System.out.println(ans);
    }
}
