import java.util.*;

class Solution
{

        public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                while (true) {
                    if (stack.peek() == s.charAt(i)) {
                        stack.pop();
                        break;
                    }
                }
                continue;
            }

            stack.add(s.charAt(i));

        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}