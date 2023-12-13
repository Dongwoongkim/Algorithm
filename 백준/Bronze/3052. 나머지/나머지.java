import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            answer.add(sc.nextInt() % 42);
        }

        System.out.println(answer.stream().distinct().count());
    }
}
