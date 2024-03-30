import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int twoCount = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;

            twoCount += num / 2;
        }

        if ((sum % 3 == 0) && (twoCount >= sum / 3)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
