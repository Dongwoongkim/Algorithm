import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
    
         for (int j = 0; j < operations.length; j++) {
                StringTokenizer st = new StringTokenizer(operations[j]);

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
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = cntMap.lastKey();
            answer[1] = cntMap.firstKey();
        }
    
        return answer;    
    }
}