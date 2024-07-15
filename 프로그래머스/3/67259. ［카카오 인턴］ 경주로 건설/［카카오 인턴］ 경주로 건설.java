import java.util.*;

class Solution {
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    public int solution(int[][] board) {
        int answer = 0;
        answer = bfs(board);
        return answer;
    }
    
    int bfs(int[][] board){
        Queue<int[]> q = new LinkedList<>();
        if(board[0][1] == 0)
            q.add(new int[]{0,1,100,2});
        if(board[1][0] == 0)
            q.add(new int[]{1,0,100,3});
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == board.length - 1 && cur[1] == board[0].length - 1)
                min = Math.min(min, cur[2]);
            
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(OOD(nr, nc, board.length, board[0].length) || board[nr][nc] == 1)
                    continue;

                int v = 0;
                if(cur[3] == i) 
                    v = cur[2] + 100;
                else {
                    v = cur[2] + 600;
                    visited[cur[0]][cur[1]] = v;
                }
                if(visited[nr][nc] < v)
                    continue;
                visited[nr][nc] = v;
                q.add(new int[]{nr, nc, v, i});
            }
        }
        return min;
    }
    
    boolean OOD(int r, int c, int rl, int cl){
        if(r < 0 || c < 0 || r >= rl || c >= cl)
            return true;
        return false;
    }
}