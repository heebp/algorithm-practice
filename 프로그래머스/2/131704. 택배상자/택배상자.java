import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        int cur = 0;
        for(int i = 1; i <= order.length; i++){
            s.push(i);
            while(!s.isEmpty() && s.peek() == order[cur]){
                s.pop();
                answer++;
                cur++;
            }
        }
        return answer;
    }
}