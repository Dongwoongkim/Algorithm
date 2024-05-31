import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name : callings) {
            Integer idx = map.get(name);
            String tmp = answer[idx - 1];
            answer[idx - 1] = answer[idx];
            answer[idx] = tmp;

            map.replace(name, idx - 1);
            map.replace(tmp, idx);
        }

        return answer;
    }
}