import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int alarmHour;
        int alarmMinute;

        if (minute - 45 < 0) {
            alarmHour = hour - 1;
            alarmMinute = minute - 45 + 60;
        } else {
            alarmHour = hour;
            alarmMinute = -1 * (45 - minute);
        }

        if (alarmHour < 0) {
            alarmHour = 23;
        }

        System.out.println(alarmHour + " " + alarmMinute);
    }
}
