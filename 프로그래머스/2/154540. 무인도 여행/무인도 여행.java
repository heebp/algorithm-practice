import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    boolean[][] visited;
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){
                    int num = bfs(new int[]{i, j}, maps);
                    if(num != 0)
                        list.add(num);
                }
            }
        }
        if(list.size() == 0)
            list.add(-1);
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int bfs(int[] p, String[] maps){
        Queue<int[]> q = new LinkedList<>();
        visited[p[0]][p[1]] = true;
        q.add(p);
        int max = 0;
        while(!q.isEmpty()){
            int[] next = q.poll();
            max += (maps[next[0]].charAt(next[1]) - '0');
            for(int i = 0; i < 4; i++){
                int x = next[0] + dx[i];
                int y = next[1] + dy[i];
                if(x < 0 || y < 0 || x >= maps.length || y >= maps[0].length() || maps[x].charAt(y) == 'X')
                    continue;
                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return max;
    }
}