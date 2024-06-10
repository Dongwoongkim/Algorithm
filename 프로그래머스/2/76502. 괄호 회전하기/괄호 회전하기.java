import java.util.*;

class Solution {
    public int solution(String line) {
        int answer = 0;
    
        Stack<Character> st = new Stack<>();
        
        for(int round = 0 ; round < line.length() ; round ++) {
            StringBuilder sb = new StringBuilder();
            
            String s = sb.append(line.substring(round, line.length()))
                        .append(line.substring(0, round))
                        .toString();
            
            boolean flag = true;
                      
            for (int i = 0 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                
                if(st.isEmpty()) {
                    if(c == ')' || c == '}' || c == ']') {
                        flag = false;
                        break;
                    }
                }
                
                
                if(c == '(' || c == '[' || c == '{') {
                    st.add(c);
                    continue;
                }

                if(!st.isEmpty()) {
                    if (c == ')' && st.peek() != '(') {
                        flag = false;
                        break;
                    } 
                    
                    if (c == ']' && st.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if (c == '}' && st.peek() != '{') {
                        flag = false;
                        break;
                    }
                    st.pop();
                }
            }
            
            if(st.isEmpty() && flag) {
                answer++;
            }
        }
        
        return answer;
    }
}