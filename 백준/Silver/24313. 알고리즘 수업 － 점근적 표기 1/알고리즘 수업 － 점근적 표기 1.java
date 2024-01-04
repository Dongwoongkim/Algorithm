import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        System.out.print(getAnswer(a1, a0, c, n0));
    }

    private static Integer getAnswer(int a1, int a0, int c, int n0) {
        int answer = 1;
        for (int i = n0; i <= 100; i++) {
            if (a1 * i + a0 > c * i) {
                answer = 0;
                break;
            }
        }
        return answer;
    }
}
