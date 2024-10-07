import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> countList = new ArrayList<>();
        for(Integer value : map.values()){
            countList.add(value);
        }
        Collections.sort(countList, Collections.reverseOrder());
        int sum = 0;
        for(Integer count : countList){
            if(sum >= k)
                break;
            sum += count;
            answer++;
        }
        return answer;
    }
}