import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int cam = routes[0][1];
        int index = 0;
        while(++index < routes.length){
            if(cam >= routes[index][0])
                continue;
            cam = routes[index][1];
            answer++;
        }
        return answer + 1;
    }
}