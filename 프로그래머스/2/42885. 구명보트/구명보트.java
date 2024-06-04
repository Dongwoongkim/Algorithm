import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int n = people.length;
        Arrays.sort(people, 0, n);
        
        int left = 0;
        int right = n - 1;
        
        while(left < right) {
            if(people[left] + people[right] <= limit) {
                answer ++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        
        if(left == right) {
            answer++;
        }
        
        return answer;
    }
}