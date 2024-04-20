import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        
        // 이동횟수가 4번보다 적은 경우
        if (height == 1) {
            System.out.println(1);
        }

        // 이동횟수가 4번보다 적은 경우
        if (height == 2) {
            System.out.println(Math.min((width + 1) / 2, 4));
        }
        
        // 이동횟수가 4번보다 적은 경우
        if (height >= 3 && width < 7) {
            System.out.println(Math.min(width, 4));
        }

        // 이동횟수가 4번 보다 많은 경우
        if (height >= 3 && width >= 7) {
            System.out.println(width - 7 + 5);
        }
    }
}
