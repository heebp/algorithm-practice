import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    static boolean[] isTrap;
    
    static class Edge{
        int v;
        int w;
        int switch_cnt;
        boolean isValid;
        int stateIdx;
        Edge(int v, int w, int switch_cnt, boolean isValid, int stateIdx){
            this.v = v;
            this.w = w;
            this.switch_cnt = switch_cnt;
            this.isValid = isValid;
            this.stateIdx = stateIdx;
        }
        void switching(int change_cnt){
            if((change_cnt - switch_cnt) % 2 != 0)
                isValid = !isValid;
            switch_cnt = change_cnt;
        }
    }
    static class Situation{
        int cur_node;
        int total_weight;
        int[] state;
        int[] visited;
        Situation(int cur_node, int total_weight, int[] state, int[] visited){
            this.cur_node = cur_node;
            this.total_weight = total_weight;
            this.state = state;
            this.visited = visited;
        }
    }
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        List<List<Edge>> graph = new ArrayList<>();
        isTrap = new boolean[n + 1];
        for(int trap : traps)
            isTrap[trap] = true;
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int stateIdx = 0;
        for(int[] road : roads){
            Edge to = new Edge(road[1], road[2], 0, true, stateIdx);
            Edge from = new Edge(road[0], road[2], 0, false, stateIdx);
            graph.get(road[0]).add(to);
            graph.get(road[1]).add(from);
            stateIdx++;
        }
        bfs(graph, start, end, roads.length, n);
        answer = min;
        return answer;
    }
    
    void bfs(List<List<Edge>> graph, int start, int end, int road_length, int n){
        Queue<Situation> q = new LinkedList<>();
        q.add(new Situation(start, 0, new int[road_length], new int[n + 1]));
        while(!q.isEmpty()){
            Situation s = q.poll();
            if(s.total_weight >= min)
                continue;
            if(s.cur_node == end){
                min =  s.total_weight;
                continue;
            }
            
            if (isTrap[s.cur_node]){
                for(Edge edge : graph.get(s.cur_node)){
                    s.state[edge.stateIdx]++;                    
                }
            }
            for(Edge edge : graph.get(s.cur_node)){
                if(!isTrap[edge.v] && s.visited[edge.v] > s.total_weight)
                    continue;
                if(s.total_weight + edge.w >= min)
                    continue;
                if(s.state[edge.stateIdx] >= 0)
                    edge.switching(s.state[edge.stateIdx]);
                if(edge.isValid){
                    s.visited[edge.v] = s.total_weight + s.visited[edge.v]; 
                    q.add(new Situation(edge.v, s.total_weight + edge.w, s.state.clone(), s.visited.clone()));
                }
            }
        }
    }
}