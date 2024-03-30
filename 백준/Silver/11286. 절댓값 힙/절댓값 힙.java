import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                // x에게 높은 우선순위를 주고 싶은 경우 -1

                // 절댓값이 같은 경우
                if (Math.abs(x) == Math.abs(y)) {
                    // 음수를 리턴
                    return x < y ? -1 : 1;
                }

                // 절댓값이 다른 경우에는 절댓값이 더 작은 값을 리턴
                return Math.abs(x) < Math.abs(y) ? -1 : 1;
            }
        });

        for (int i = 1; i <= n; i++) {
            int number = sc.nextInt();

            if (number == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
                continue;
            }
            pq.add(number);
        }

        System.out.print(sb);
    }
}
