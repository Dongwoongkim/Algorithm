import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int index = sc.nextInt();

        System.out.print(s.substring(index - 1, index));
    }
}
