import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        for(int i = prices.length - 1; i >= 0; i--){
            while(!s.isEmpty() && prices[i] <= prices[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                answer[i] = prices.length - i - 1;
                s.push(i);
            }else{
                answer[i] = s.peek() - i;
                s.push(i);
            }
        }
        return answer;
    }
}