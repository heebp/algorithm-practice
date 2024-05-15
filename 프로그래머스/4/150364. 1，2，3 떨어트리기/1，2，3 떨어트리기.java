import java.util.*;

class Solution {

    public int[] solution(int[][] edges, int[] target) {
        List<Integer> answer = new ArrayList<>();
        int[] turn = new int[target.length];
        Map<Integer, Integer> visited = new LinkedHashMap<>();
        Map<Integer, Integer> targetMap = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        for(int i = 0; i <= target.length; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < target.length; i++){
            if(target[i] != 0)
                targetMap.put(i + 1, target[i]);
        }
        
        for(int[] e : edges)
            graph.get(e[0]).add(e[1]);
        
        for(int i = 0; i <= target.length; i++)
            Collections.sort(graph.get(i));
        
        boolean isContinue = true;
        while(isContinue){
            
            dfs(1, graph, turn, visited, targetMap, track);
            
            for(int remain : targetMap.values()){
                if(remain > 0){
                    isContinue = true;
                    break;
                }
                isContinue = false;
            }
        }
        
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            List list = recur(target[k - 1], v, new ArrayList<>(), 1);
            if(list == null)
                return new int[]{-1};
            resultMap.put(k, list);
        }
        for(int i = 0; i < track.size(); i++){
            List<Integer> blocks = resultMap.get(track.get(i));
            answer.add(blocks.get(0));
            blocks.remove(0);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    void dfs(int node, List<List<Integer>> graph, int[] turn,
        Map<Integer, Integer> visited, Map<Integer, Integer> targetMap, List<Integer> track){
        
        List<Integer> children = graph.get(node);
        
        if(children != null && children.size() > 0){
            Integer child = children.get(turn[node]);
            turn[node] = (turn[node] + 1) % children.size();
            dfs(child, graph, turn, visited, targetMap, track);
        }else{
            Integer target = targetMap.get(node);
            targetMap.put(node, target - 3);
            visited.put(node, visited.getOrDefault(node, 0) + 1);
            track.add(node);
        }
    }
    
    List<Integer> recur(int target, int blockCnt, List<Integer> list, int index){
        if(blockCnt == 0){
            if(target == 0)
                return list;
            return null;
        }
        List<Integer> result = null;
        for(int i = index; i <= 3; i++){
            list.add(i);
            result = recur(target - i, blockCnt - 1, list, i);
            if(result != null)
                break;
            list.remove(list.size() - 1);
        }
        return result;
    }
}