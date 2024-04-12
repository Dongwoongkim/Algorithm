import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static long ans = 0;
    static List<Integer> bags = new ArrayList<>();
    static List<Jewel> jewels = new ArrayList<>();

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewels.add(new Jewel(weight, value));
        }

        Collections.sort(jewels);

        Queue<Jewel> queue = new LinkedList<>();

        for (int i = 0; i < jewels.size(); i++) {
            queue.add(jewels.get(i));
        }

        for (int i = 0; i < k; i++) {
            bags.add(sc.nextInt());
        }

        Collections.sort(bags);

        int idx = 0;
        for (Integer bag : bags) {
            for (int i = idx; i < n; i++) {
                if (jewels.get(i).weight <= bag) {
                    // 보석을 작은 무게부터 탐색하면서 선택한 가방의 무게보다 같거나 작은 보석을 우선순위큐에 삽입
                    pq.add(jewels.get(i).value);

                    // 중복 삽입을 방지하기 위해 시작 지점 증가시키기
                    idx++;
                    continue;
                }
                break;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }

    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

