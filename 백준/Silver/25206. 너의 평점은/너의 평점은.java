import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double gradeSum = 0;

        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine();
            List<String> subject = Arrays.stream(line.split(" ")).collect(Collectors.toList());

            if (subject.get(2).equals("P")) {
                continue;
            }

            double grade = Double.parseDouble(subject.get(1));
            gradeSum += grade;

            sum += grade * getScore(subject.get(2));
        }
        System.out.print(sum / (gradeSum));
    }

    private static double getScore(String score) {
        if (score.equals("A+")) {
            return 4.5;
        }

        if (score.equals("A0")) {
            return 4.0;
        }

        if (score.equals("B+")) {
            return 3.5;
        }

        if (score.equals("B0")) {
            return 3.0;
        }

        if (score.equals("C+")) {
            return 2.5;
        }

        if (score.equals("C0")) {
            return 2.0;
        }

        if (score.equals("D+")) {
            return 1.5;
        }

        if (score.equals("D0")) {
            return 1.0;
        }

        return 0.0;
    }
}
