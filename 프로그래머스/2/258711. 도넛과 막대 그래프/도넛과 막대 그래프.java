import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] nodeCnt;
    static int[] answer;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        int maxNode = -1;
        for(int[] edge : edges)
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        
        visited = new boolean[maxNode + 1];
        nodeCnt = new int[maxNode + 1];
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= maxNode; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            nodeCnt[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
        }
        int start = 0;
        for(int i = 1; i <= maxNode; i++){
            if(graph.get(i).size() > 1 && nodeCnt[i] == 0){
                start = i;
                break;
            }
        }
        visited = new boolean[maxNode + 1];
        answer[0] = start;
        dfs(graph, start);
        return answer;
    }
    void dfs(List<ArrayList<Integer>> graph, int start){
        Queue<Integer> q = new LinkedList<>();
        for(int first : graph.get(start)){
            int edgeCnt = 0;
            int nodeCnt = 0;
            q.add(first);
            visited[first] = true;
            while(!q.isEmpty()){
                int v = q.poll();
                nodeCnt++;
                for(int next : graph.get(v)){
                    edgeCnt++;
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            if(edgeCnt == nodeCnt)
                answer[1]++;
            else if(edgeCnt == nodeCnt - 1)
                answer[2]++;
            else
                answer[3]++;
        }
    }
}