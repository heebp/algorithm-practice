import java.util.*;

class Solution {
    static int[] dx = {0, 1, -1};
    static int[] dy = {1, 0, -1};
    public int[] solution(int n) {
        int[] answer = {};
        int[][] triangle = new int[n][n];
        int x = 0;
        int y = 0;
        int index = 0;
        int value = 1;
        int max = (n * (n + 1)) / 2;
        while(true){
            triangle[x][y] = value++;            
            int nx = x + dx[index];
            int ny = y + dy[index];
            if(nx == n || ny == n || triangle[nx][ny] != 0){
                index = (index + 1) % 3;
                nx = x + dx[index];
                ny = y + dy[index];
            }
            if(max < value)
                break;
            x = nx;
            y = ny;
        }
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(triangle[j][i] != 0)
                    arr.add(triangle[j][i]);
                else
                    break;
            }
        }  
        answer = new int[max];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}