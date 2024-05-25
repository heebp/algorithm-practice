import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[2];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(String operation : operations){
            String[] op = operation.split("\\s");
            char cmd = op[0].charAt(0);
            int num = Integer.parseInt(op[1]);
            if (cmd == 'I') {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            } else {
                if (num == 1) {
                    delete(treeMap, treeMap.lastEntry());
                } else {
                    delete(treeMap, treeMap.firstEntry());
                }
            }
        }
        if (treeMap.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = treeMap.lastKey();
            answer[1] = treeMap.firstKey();
        }
        return answer;
    }
    
    private static void delete(Map<Integer, Integer> treeMap, Map.Entry<Integer, Integer> entrySet) {
        if(entrySet == null)
            return;
        if(entrySet.getValue() > 1){
            treeMap.put(entrySet.getKey(), entrySet.getValue() - 1);
        }else{
            treeMap.remove(entrySet.getKey());
        }
    }
}