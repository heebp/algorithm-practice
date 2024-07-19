import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < info.length; i++)
            graph.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            List<Integer> s = graph.get(edges[i][0]);
            List<Integer> e = graph.get(edges[i][1]);
            s.add(edges[i][1]);
            e.add(edges[i][0]);
        }
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        
        answer = dfs(new ArrayList<>(){{add(0);}}, 1, 0, graph, visited, info);
        return answer;
    }
    
    int dfs(List<Integer> curNodes, int sheep, int wolf, List<List<Integer>> graph, boolean[] visited, int[] info){
        if(sheep == wolf)
            return sheep;
        int max = Integer.MIN_VALUE;
        for(int cur  : curNodes){
            for(int node : graph.get(cur)){
                if(visited[node])
                    continue;
                visited[node] = true;
                if(info[node] == 0)
                    max = Math.max(max, dfs(new ArrayList<>(curNodes){{add(node);}}, sheep + 1, wolf, graph, visited, info));
                else
                    max = Math.max(max, dfs(new ArrayList<>(curNodes){{add(node);}}, sheep, wolf + 1, graph, visited, info));
                visited[node] = false;
            }
        }
        return max > sheep ? max : sheep;
    }
}