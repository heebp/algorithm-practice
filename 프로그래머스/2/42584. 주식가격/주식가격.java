import java.util.*;
//1,2,3,2,3,1
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        for(int i = prices.length - 1; i >= 0; i--){
            while(!s.isEmpty() && prices[s.peek()] >= prices[i]){
                s.pop();
            }
            answer[i] = s.isEmpty() ? prices.length - i - 1 : s.peek() - i;
            s.add(i);
        }
        return answer;
    }
}