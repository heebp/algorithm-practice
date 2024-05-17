import java.util.*;

class Solution {
    int[] dr = {-1,0,0,1};
    int[] dc = {0,-1,1,0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++){
            answer[i] = bfs(places[i]);
        }
        return answer;
    }
    int bfs(String[] place){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(place[i].charAt(j) == 'P')
                    q.add(new int[]{i, j, 2, i , j});
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[2] == 0)
                break;
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(OOD(nr,nc))
                    continue;
                if(nr == cur[3] && nc == cur[4])
                    continue;
                if(place[nr].charAt(nc) == 'P')
                    return 0;
                if(place[nr].charAt(nc) == 'X')
                    continue;
                q.add(new int[]{nr, nc, cur[2] - 1, cur[3], cur[4]});
            }
        }
        return 1;
    }
    boolean OOD(int nr, int nc){
        if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5)
            return true;
        return false;
    }
}