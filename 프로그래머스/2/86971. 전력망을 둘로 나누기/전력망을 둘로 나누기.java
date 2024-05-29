import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        answer = Integer.MAX_VALUE;
        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for(int[] wire : wires){
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            boolean[] visited = new boolean[n + 1];

            int cnt = bfs(graph, visited);

            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);

            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return answer;
    }

    int bfs(List<ArrayList<Integer>> graph, boolean[] visited){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        while(!q.isEmpty()){
            int v = q.poll();
            cnt++;
            for(int next : graph.get(v)){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }
}