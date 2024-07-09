import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int curTime = (int)Math.ceil((double)(100 - progresses[0]) / speeds[0]);
        int prev  = 0;
        for(int i = 1; i < progresses.length; i++){
            int time = (int)Math.ceil((double)(100 - progresses[i]) /speeds[i]);
            if(curTime < time){
                curTime = time;
                list.add(i - prev);   
                prev = i;
            }
        }
        list.add(progresses.length - prev);
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}