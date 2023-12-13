import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int requiredMinute = sc.nextInt();

        int answerMinute = (minute + requiredMinute) % 60;
        int answerHour = ((minute + requiredMinute) / 60 + hour) % 24;

        System.out.println(answerHour + " " + answerMinute);
    }
}

