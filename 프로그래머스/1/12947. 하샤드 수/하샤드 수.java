class Solution {
    public boolean solution(int x) {
        int tmp = x;
        int sum = 0;
        
        while(true) {
            if(tmp == 0) {
                break;
            }
            sum += tmp % 10;
            tmp /= 10;
        }
        
        if(x % sum == 0) {
            return true;
        }
        return false;
    }
}