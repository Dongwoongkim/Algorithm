import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] arr = new int[2];
        
        int total = brown + yellow;
        
        for(int i = 1; i<= total; i++) {
            if(total % i == 0) {
                if(total / i >= i) {
                    arr[0] = total / i;
                    arr[1] = i;
                    int y = (arr[0] - 2) * (arr[1] - 2);
                    
                    if(y == yellow) {
                        break;
                    }
                }
            }
        }
        
        return arr;
    }
}