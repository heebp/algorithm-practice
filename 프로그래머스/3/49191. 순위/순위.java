import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        
        for(int i = 0; i < results.length; i++){
            List<Integer> winList = win.get(results[i][0]);
            List<Integer> loseList = lose.get(results[i][1]);
            
            winList.add(results[i][1]);
            loseList.add(results[i][0]);
        }
        for(int i = 1; i <= n; i++){
            if(dfs(i, win, 0, new boolean[n + 1]) + dfs(i, lose, 0, new boolean[n + 1]) == n - 1)
                answer++;
        }
        return answer;
    }
    
    int dfs(int s, List<List<Integer>> graph, int sum, boolean[] visited){
        List<Integer> cur = graph.get(s);
        for(int node : cur){
            if(!visited[node]){
                visited[node] = true;
                sum += dfs(node, graph, 1, visited);
            }
        }
        return sum;
    }
}