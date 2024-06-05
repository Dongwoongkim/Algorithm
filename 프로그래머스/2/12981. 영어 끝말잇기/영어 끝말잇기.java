import java.util.*;

class Solution {
       public static int[] solution(int n, String[] words) {
        Set<String> dict = new HashSet<>();

        int[] answer = new int[2];

        int turn = 1;
        char end = words[0].charAt(words[0].length() - 1);

        dict.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            turn = (turn + 1) % (n + 1);

            if (turn == 0) {
                turn = 1;
            }

            if (dict.contains(words[i]) || words[i].charAt(0) != end) {
                answer[0] = turn;
                answer[1] = i / n + 1;
                break;
            } else {
                dict.add(words[i]);
                end = words[i].charAt(words[i].length() - 1);
            }
        }

        return answer;
    }
}