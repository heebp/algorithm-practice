import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cnt = 0;
        int tot = 0;
        int cur = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(cnt < truck_weights.length){
            if(!q.isEmpty() && q.peek()[1] == time){
                int[] out = q.poll();
                tot -= out[0];
                cnt++;
            }
            if(cur < truck_weights.length && truck_weights[cur] + tot <= weight){
                q.add(new int[]{truck_weights[cur], time + bridge_length});
                tot += truck_weights[cur];
                cur++;
            }
            time++;
        }
        answer = time;
        return answer;
    }
}