class Solution {
    public int solution(int n) {
        int answer = 0;
        long num1 = 1;
        long num2 = 0;
        long temp = 0;
        for(int i = 0; i < n; i++){
            temp = num1;
            num1 += num2 % 1234567;
            num2 = temp;
        }
        answer = (int)(num2 % 1234567);
        return answer;
    }
}