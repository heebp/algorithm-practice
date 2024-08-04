import java.util.*;

class Solution {
    static class Situation{
        String row;
        String col;
        int cnt;
        Situation(String row, String col, int cnt){
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;
        answer = bfs(beginning, target);
        return answer;
    }
    int bfs(int[][] beginning, int[][] target){
        Queue<Situation> q = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        int length = beginning.length + beginning[0].length;
        
        StringBuilder rowSb = new StringBuilder();
        for(int i = 0; i < beginning.length; i++)
            rowSb.append("0");
        
        StringBuilder colSb = new StringBuilder();
        for(int i = 0; i < beginning[0].length; i++)
            colSb.append("0");
        
        visited.put(rowSb.toString(), true);
        visited.put(colSb.toString(), true);
        
        q.add(new Situation(rowSb.toString(), colSb.toString(), 0));
        
        while(!q.isEmpty()){
            Situation s = q.poll();
            if(s.cnt > length)
                return -1;
            
            int[][] map = convertToMap(beginning, s.row, s.col);
            if(compare(map, target))
                return s.cnt;
            StringBuilder row = new StringBuilder(s.row);
            StringBuilder col = new StringBuilder(s.col);
            
            for(int i = 0; i < length; i++){
                if(i < beginning.length){
                    if(row.charAt(i) == '1')
                        continue;
                    row.setCharAt(i, '1');
                    if(visited.get(row.toString() + col.toString()) == null){
                        visited.put(row.toString() + col.toString(), true);
                        q.add(new Situation(row.toString(), col.toString(), s.cnt + 1));
                        
                    }
                    row.setCharAt(i, '0');
                }else {
                    if(col.charAt(i - beginning.length) == '1')
                        continue;
                    col.setCharAt(i - beginning.length, '1');
                    if(visited.get(row.toString() + col.toString()) == null){
                        visited.put(row.toString() + col.toString(), true);
                        q.add(new Situation(row.toString(), col.toString(), s.cnt + 1));
                    }
                    col.setCharAt(i - beginning.length,'0');
                }
            }
        }
        return -1;
    }
    int[][] convertToMap(int[][] beginning, String r, String c){
        int[][] map = new int[beginning.length][];
        for (int i = 0; i < beginning.length; i++) {
            map[i] = new int[beginning[i].length];
            for (int j = 0; j < beginning[i].length; j++) {
                map[i][j] = beginning[i][j];
            }
        }
        for(int i = 0; i < r.length(); i++){
            if(r.charAt(i) == '1'){
                for(int j = 0; j < c.length(); j++)
                    map[i][j] = map[i][j] == 1 ? 0 : 1;
            }
        }
        for(int i = 0; i < c.length(); i++){
            if(c.charAt(i) == '1'){
                for(int j = 0; j < r.length(); j++)
                    map[j][i] = map[j][i] == 1 ? 0 : 1;
            }
        }
        return map;
    }

    boolean compare(int[][] map, int[][] target){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
}