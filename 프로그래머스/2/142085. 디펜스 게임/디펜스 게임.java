import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            sum += enemy[i];
            pq.add(enemy[i]);
            if(sum > n){
                if(k == 0)
                    return i;
                sum -= pq.poll();
                k--;
            }
        }
        answer = enemy.length;
        return answer;
    }
}