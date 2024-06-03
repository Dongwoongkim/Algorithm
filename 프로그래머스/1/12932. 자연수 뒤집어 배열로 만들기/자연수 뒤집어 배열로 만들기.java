class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int idx = 0;
        while(true) {
            if(n == 0) {
                break;
            }
            
            answer[idx++] = (int) (n % 10);
            n /= 10;
        }
        
        
        return answer;
    }
}