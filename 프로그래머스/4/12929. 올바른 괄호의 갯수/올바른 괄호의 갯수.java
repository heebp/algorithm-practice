//0011 0101 0110 1001 1010 => 0 /// 11
class Solution {
    public int solution(int n) {
        int answer = 0;
        int open = n - 1;
        int close = n - 1;
        return dfs(open, close);
    }
    int dfs(int open, int close){
        if(open == 0 && close == 0){
            return 1;
        }
        if(open < 0 || close < 0){
            return 0;
        }
        int res = 0;
        res += dfs(open - 1, close);
        if(open <= close)
            res += dfs(open, close - 1);
        return res;
    }
}