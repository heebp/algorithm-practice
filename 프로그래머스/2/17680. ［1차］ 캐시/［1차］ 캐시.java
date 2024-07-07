import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> cache = new LinkedHashSet<>();
        
        for(String city : cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                cache.remove(city);
                answer++;
            }else{
                Iterator<String> iter = cache.iterator();
                if(iter.hasNext() && cache.size() >= cacheSize){
                    String removed = iter.next();
                    cache.remove(removed);
                }
                answer += 5;
            }
            if(cache.size() < cacheSize)
                cache.add(city);
        }
        return answer;
    }
}