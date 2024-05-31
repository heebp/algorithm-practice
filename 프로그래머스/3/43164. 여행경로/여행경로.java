import java.util.*;

class Solution {
    class Node {
        String to;
        boolean visited;
        Node(String t, boolean v){
            to = t;
            visited = v;
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Map<String, List<Node>> graph = new HashMap<>();
        int idx = 0;
        for(String[] ticket : tickets){
            List<Node> list = graph.getOrDefault(ticket[0], new ArrayList<>());
            list.add(new Node(ticket[1], false));
            graph.put(ticket[0], list);
        }
        Set<String> set = new HashSet<>();
        for(String[] ticket : tickets){
            set.add(ticket[0]);
            set.add(ticket[1]);
        }
        for(List<Node> list : graph.values()){
            for(Node node : list)
                System.out.println(node.to);
            list.sort((o1, o2) -> o1.to.compareTo(o2.to));
        }
        List<String> visited = dfs("ICN", graph, new ArrayList<>(){{add("ICN");}}, tickets.length + 1);
        answer = new String[visited.size()];
        for(int i = 0; i < visited.size(); i++){
            answer[i] = visited.get(i);
        }
        return answer;
    }
    List<String> dfs(String cur, Map<String, List<Node>> graph, List<String> visited, int size){
        if(visited.size() == size)
            return visited;
        List<String> result = null;
        if(graph.get(cur) == null)
            return new ArrayList<>();
        for(Node node : graph.get(cur)){
            if(node.visited)
                continue;
            visited.add(node.to);
            node.visited = true;
            result = dfs(node.to, graph, visited, size);
            if(result.size() == size)
                break;
            node.visited = false;
            visited.remove(visited.size() - 1);
        }
        return result;
    }
}