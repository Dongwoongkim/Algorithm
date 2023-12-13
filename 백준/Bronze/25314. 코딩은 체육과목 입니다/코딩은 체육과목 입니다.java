import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        printAnswer(x / 4);
    }

    private static void printAnswer(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
