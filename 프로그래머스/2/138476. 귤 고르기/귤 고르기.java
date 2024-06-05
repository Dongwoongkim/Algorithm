import java.util.*;

class Solution {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            if (!map.containsKey(tangerine[i])) {
                map.put(tangerine[i], 1);
            } else {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            }
        }

        PriorityQueue<Tangerine> pq = new PriorityQueue<>();
        for (Integer i : map.keySet()) {
            pq.add(new Tangerine(i, map.get(i)));
        }

        int sum = 0;
        while (true) {
            if (sum >= tangerine.length - k) {
                break;
            }
            
            if (sum + pq.peek().frequency > tangerine.length - k) {
                break;
            }
            sum += pq.poll().frequency;
        }

        return pq.size();
    }

    static class Tangerine implements Comparable<Tangerine> {
        int size;
        int frequency;

        public Tangerine(int size, int frequency) {
            this.size = size;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Tangerine o) {
            return Integer.compare(this.frequency, o.frequency);
        }
    }
}