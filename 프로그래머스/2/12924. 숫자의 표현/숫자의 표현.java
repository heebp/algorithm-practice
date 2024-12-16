class Solution {
    
    public int solution(int n) {
        int answer = 0;
        int s = 0;
        int e = 1;
        int sum = 0;
        while(s != n){
            if(sum == n){
                answer++;
                s++;
                sum -= s;
            }else if(sum < n){
                sum += e;
                e++;
            }else {
                s++;
                sum -= s;
            }
        }
        return answer;
    }
}