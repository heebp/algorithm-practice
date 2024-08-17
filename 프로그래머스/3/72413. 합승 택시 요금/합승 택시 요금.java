import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] fare : fares){
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
        int[] ds = dijkstra(graph, s);
        int[] da = dijkstra(graph, a);
        int[] db = dijkstra(graph, b);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n; i++){
            if(ds[i] == Integer.MAX_VALUE)
                continue;
            min = Math.min(min, ds[i] + da[i] + db[i]);
        }
        answer = min;
        return answer;
    }
    int[] dijkstra(List<List<int[]>> graph, int x){
        int[] v = new int[graph.size()];
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        Arrays.fill(v, Integer.MAX_VALUE);
        v[x] = 0;
        pq.add(new int[]{x, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int[] next : graph.get(cur[0])){
                if(v[next[0]] <= v[cur[0]] + next[1])
                    continue;
                v[next[0]] = v[cur[0]] + next[1];
                pq.add(new int[]{next[0], v[next[0]]});
            }
        }
        return v;
    }
}