import java.util.*;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] subArr = new int[weights.length - 1];
        for(int i = 0; i < weights.length - 1; i++){
            subArr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(subArr);
        long max = 0;
        long min = 0;
        System.out.println(Arrays.toString(subArr));
        for(int i = 0; i < k - 1; i++){
            min += subArr[i];
            max += subArr[subArr.length - 1 - i];
        }
        return max - min;
    }
}