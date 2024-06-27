import java.util.*;

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<Set<Integer>> graph = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++)
            graph.add(new HashSet<>());

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            map.put(e[0] + ","+ e[1], Math.min(e[2], map.getOrDefault(e[0] + ","+ e[1], e[2])));
            map.put(e[1] + ","+ e[0], Math.min(e[2], map.getOrDefault(e[1] + ","+ e[0], e[2])));
        }

        int[] answer = new int[n];
        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.MAX_VALUE;
        }

        dijkstra(answer, graph, disappear, map);
        for(int i = 0; i < answer.length; i++){
            if(answer[i] == Integer.MAX_VALUE)
                answer[i] = -1;
        }
        return answer;
    }
    static void dijkstra(int[] answer, List<Set<Integer>> graph, int[] disappear, Map<String, Integer> map){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        answer[0] = 0;
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(answer[cur[0]] != cur[1])
                continue;
            for(int node : graph.get(cur[0])){
                int v = cur[1] + map.get(cur[0] +","+node);
                if(disappear[node] <= v)
                    continue;
                if(answer[node] <= v)
                    continue;
                answer[node] = v;
                pq.add(new int[]{node, v});
            }
        }
    }
}