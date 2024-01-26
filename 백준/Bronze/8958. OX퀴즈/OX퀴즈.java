import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            String str = sc.nextLine();
            int score = 0;
            int sum = 1;
            for (int j = 0; j < str.length(); j++) {

                char ch = str.charAt(j);
                if(ch=='O')
                {
                    score+=sum++;
                }
                else if(ch =='X') {
                    sum = 1;
                }
            }
            System.out.println(score);
        }
    }
}
