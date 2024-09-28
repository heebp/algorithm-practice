

class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        while(Math.abs(a - b) > 1 || a / 2 == b / 2){
            if(a % 2 == 1)
                a++;
            if(b % 2 == 1)
                b++;
            a /= 2;
            b /= 2;
            answer++;
        }
        return answer;
    }
}