// a : 첫집을 털었고, 마지막 집을 안 털었을 경우
// b : 첫집을 안 털었고, 마지막 집을 털었을 경우
// c : 첫집을 안 털었고, 마지막 집을 안 털었을 경우

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length + 1];
        dp = money.clone();
        dp[0] = 0;
        money[1] = money[0] > money[1] ? money[0] : money[1];
        for(int i = 2; i < money.length - 1; i++){
            money[i] = Math.max(money[i - 1], money[i - 2] + money[i]);
        }

        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        answer = Math.max(money[money.length - 2], dp[dp.length - 1]);
        return answer;
    }
}