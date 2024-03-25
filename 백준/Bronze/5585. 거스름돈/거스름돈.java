import java.util.Scanner;

public class Main {

    static int n;
    static int money;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        money = 1000 - n;
        System.out.println(
                getAnswer(500) 
            + getAnswer(100) 
            + getAnswer(50) 
            + getAnswer(10) 
            + getAnswer(5) 
            + getAnswer(1));
    }

    private static int getAnswer(int change) {
        int cnt = 0;

        cnt += money / change;
        money %= change;

        return cnt;
    }
}
