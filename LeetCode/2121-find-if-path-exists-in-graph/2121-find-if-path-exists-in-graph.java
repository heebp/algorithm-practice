import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            List<Integer> s = graph.get(edges[i][0]);
            List<Integer> e = graph.get(edges[i][1]);
            s.add(edges[i][1]);
            e.add(edges[i][0]);
        }
        if(n == 1 || source == destination || pathExists(source, destination, graph, n))
            return true;
        return false;
    }
    boolean pathExists(int s, int e, List<List<Integer>> graph, int n){
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        for(int node : graph.get(s)){
            q.add(node);
            visited[node] = true;
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == e)
                return true;
            for(int node : graph.get(cur)){
                if(visited[node])
                    continue;
                visited[node] = true;
                q.add(node); 
            }
        }
        return false;
    }
}