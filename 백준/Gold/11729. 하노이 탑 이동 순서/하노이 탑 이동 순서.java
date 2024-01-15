import java.io.IOException;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        hanoi(n, 1, 2, 3);

        System.out.println((int) Math.pow(2, n) - 1);
        System.out.print(sb);
    }

    private static void hanoi(int n, int start, int mid, int goal) {
        if (n == 1) {
            sb.append(start + " " + goal).append("\n");
            return;
        }

        hanoi(n - 1, start, goal, mid); // (n-1)개 start -> mid로 이동
        sb.append(start + " " + goal).append("\n"); // 가장 큰 원판 start 에서 goal로 이동
        hanoi(n - 1, mid, start, goal); // (n-1)개 mid -> start로 이동
    }
}
