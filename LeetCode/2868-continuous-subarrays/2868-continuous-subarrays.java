import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int s = 0;
        long res = 0;
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(Math.abs(map.firstEntry().getKey() - map.lastEntry().getKey()) > 2){
                map.put(nums[s], map.getOrDefault(nums[s], 0) - 1);
                if(map.get(nums[s]) == 0)
                    map.remove(nums[s]);
                s++;
            }
            res += i - s + 1;        
        }
        return res;
    }
}