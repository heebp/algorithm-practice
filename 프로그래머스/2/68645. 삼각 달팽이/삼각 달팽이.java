import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1};
    static int[] dc = {0, 1, -1};
    //삼각형을 배열 형태(사각형)으로 구현 => 배열에선 직각 삼각형
    
    //0,0부터 아래 방향 진행
    
    //아래가 막혀있을때,(index out, num 존재) 진행 방향을 반시계 방향으로 바꿈
    
    //종료 조건 : 방향 전환 시에 바로 막혀있는 경우 종료 
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[] pos = {0,0};
        int dir = 0;
        int cnt = 1;
        int r = 0;
        int c = 0;
        while(true){
            if(r < 0 || c < 0 || r >= n || c >= n)
                break;
            map[r][c] = cnt;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] != 0){
                dir = (dir + 1) % 3;
                nr = r + dr[dir];
                nc = c + dc[dir];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] != 0)
                    break;
            }
            
            r = nr;
            c = nc;
            cnt++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 0)
                    break;
                list.add(map[i][j]);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}