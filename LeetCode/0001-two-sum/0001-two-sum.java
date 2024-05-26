import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Integer[][] idxNums = new Integer[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            idxNums[i][0] = i;
            idxNums[i][1] = nums[i];
        }
        Arrays.sort(idxNums, (o1, o2) -> o1[1] - o2[1]);
        int s = 0;
        int e = nums.length - 1;
        while(s < e){
            int sum = idxNums[s][1] + idxNums[e][1];
            if(sum == target){
                return new int[]{idxNums[s][0], idxNums[e][0]};
            }else if(sum < target)
                s++;
            else
                e--;
        }
        return null;
    }
}