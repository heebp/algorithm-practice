import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> target = new HashMap<>();
        for(int i = 0; i < topping.length; i++){
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        for(int i = 0; i < topping.length; i++){
            if(compare(map, target)){
                answer++;
            }
            int cnt = map.get(topping[i]);
            if(cnt == 1)
                map.remove(topping[i]);
            else map.put(topping[i], map.getOrDefault(topping[i], 0) - 1);
            target.put(topping[i], target.getOrDefault(topping[i], 0) + 1);
        }
        
        return answer;
    }
    boolean compare(Map<Integer, Integer> map, Map<Integer, Integer> target){
        return map.size() == target.size() ? true : false;   
    }
}