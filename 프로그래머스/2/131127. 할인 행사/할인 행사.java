import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i= 0; i < 10; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        int s = 0;
        int e = 10;
        while(e < discount.length){
            if (checkDiscount(map, discountMap)){
               answer++;
            }
            discountMap.put(discount[s], discountMap.get(discount[s]) - 1);
            s++;
            discountMap.put(discount[e], discountMap.getOrDefault(discount[e], 0) + 1);
            e++;
        }
        if (checkDiscount(map, discountMap)){
           answer++;
        }
        return answer;
    }
    boolean checkDiscount(Map<String, Integer> src, Map<String, Integer> target){
        int cnt = 0;
        for(String s : src.keySet()){
            if(src.get(s) == target.get(s))
                cnt++;
        }
        if(src.size() == cnt)
            return true;
        return false;
    }
}