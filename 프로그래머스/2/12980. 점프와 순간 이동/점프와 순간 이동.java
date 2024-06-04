import java.util.*;

public class Solution {
    public int solution(int n) {
        int cnt = 0;
        while(true) {
            if(n == 0) { 
               break; 
            }
            
            if(n % 2 == 0) {
                n /= 2;
                continue;
            }
            
            if(n % 2 == 1) {
                n -= 1;
                cnt++;
            }
        }
        
        return cnt;
    }
}