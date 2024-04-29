import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int maxDistance = (int) Math.sqrt(e - s);

            if (maxDistance == Math.sqrt(e - s)) {
                System.out.println(2 * maxDistance - 1);
                continue;
            }

            if ((e - s) <= maxDistance * maxDistance + maxDistance) {
                System.out.println(2 * maxDistance);
                continue;
            }

            System.out.println(2 * maxDistance + 1);

        }
    }
}
