class Solution {
    public long solution(int n) {
        long answer = 0;
    
        long[] dp = new long[2002];
    
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<= n; i++) {
            // 한 칸 이전에서 한 칸 뛰는 경우 +
            // 두 칸 이전에서 두 칸 뛰는 경우 
            dp[i] += (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n] % 1234567;
    }
}