import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        List<Integer> answer = getAnswer(q, m, sb);
        String result = answer.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "<", ">"));
        System.out.print(result);
    }

    private static List<Integer> getAnswer(Queue<Integer> q, int m, StringBuilder sb) {
        List<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                q.add(q.poll());
            }
            arr.add(q.poll());
        }

        return arr;
    }
}
