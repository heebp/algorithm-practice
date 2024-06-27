class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
            
        long left = 0;
        long right = 1_000_000_000 * 2L * 100_000 * 2L;
        while(left <= right){
            long mid = (left + right) / 2;
            int a_sum = 0;
            int b_sum = 0;
            long total = 0;
            for(int i = 0; i < g.length; i++){
                long cnt = mid / (t[i] * 2);
                if (mid % (t[i] * 2) >= t[i]) 
                    cnt++;
                long tmp = Math.min(cnt * w[i], g[i] + s[i]);
                total += tmp;
                a_sum += Math.min(tmp, g[i]);
                b_sum += Math.min(tmp, s[i]);                
            }
            
            if(total < a + b || a > a_sum || b > b_sum){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}