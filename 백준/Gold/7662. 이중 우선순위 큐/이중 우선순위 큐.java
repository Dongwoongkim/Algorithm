
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> cntMap = new TreeMap<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0);
                int number = Integer.parseInt(st.nextToken());

                // 최댓값을 삭제하는 명령
                if (command == 'D' && number == -1) {
                    if (cntMap.isEmpty()) {
                        continue;
                    }
                    int cnt = cntMap.getOrDefault(cntMap.firstKey(), 0);

                    if (cnt == 0) {
                        continue;
                    }
                    if (cnt == 1) {
                        cntMap.remove(cntMap.firstKey());
                    } else {
                        cntMap.put(cntMap.firstKey(), cntMap.get(cntMap.firstKey()) - 1);
                    }
                }

                // 최솟값을 삭제하는 명령
                if (command == 'D' && number == 1) {
                    if (cntMap.isEmpty()) {
                        continue;
                    }
                    int cnt = cntMap.getOrDefault(cntMap.lastKey(), 0);

                    if (cnt == 0) {
                        continue;
                    }

                    if (cnt == 1) {
                        cntMap.remove(cntMap.lastKey());
                    } else {
                        cntMap.put(cntMap.lastKey(), cntMap.get(cntMap.lastKey()) - 1);
                    }
                }

                // Queue에 number 삽입
                if (command == 'I') {
                    cntMap.put(number, cntMap.getOrDefault(number, 0) + 1);
                }
            }

            if (cntMap.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(cntMap.lastKey() + " " + cntMap.firstKey());
            }
        }
    }
}
