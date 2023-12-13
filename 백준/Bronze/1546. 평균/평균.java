import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Double> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scores.add(sc.nextDouble());
        }

        double maxScore = scores.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0);

        for (int i = 0; i < n; i++) {
            scores.set(i, scores.get(i) / maxScore * 100);
        }

        System.out.print(scores.stream().mapToDouble(Double::doubleValue).average().orElse(0));
    }
}
