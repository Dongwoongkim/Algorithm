import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> home = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            home.add(sc.nextInt());
        }

        Collections.sort(home);

        if (n % 2 == 1) {
            System.out.println(home.get(n / 2));
        } else {
            System.out.println(home.get(n / 2 - 1));
        }
    }
}
