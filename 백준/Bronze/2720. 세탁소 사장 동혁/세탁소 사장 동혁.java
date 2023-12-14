import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;

        for (int i = 0; i < t; i++) {
            int change = Integer.parseInt(br.readLine());
            int quarterCount = getCount(change, quarter);
            change = change - quarter * quarterCount;

            int dimeCount = getCount(change, dime);
            change = change - dime * dimeCount;

            int nickelCount = getCount(change, nickel);
            change = change - nickel * nickelCount;

            int pennyCount = getCount(change, penny);

            System.out.println(String.format("%d %d %d %d", quarterCount, dimeCount, nickelCount, pennyCount));
        }
    }

    private static int getCount(int change, int coin) {
        return change / coin;
    }
}
