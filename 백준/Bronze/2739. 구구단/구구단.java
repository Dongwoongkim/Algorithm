import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printAnswer(sc.nextInt());
    }

    private static void printAnswer(int number) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        }
    }
}