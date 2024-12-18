class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[n + 3];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer = dp[n] % 1234567;
        return answer;
    }
}