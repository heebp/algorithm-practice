import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return binary_search(weights, days);
    }

    int binary_search(int[] weights, int days){
        int s = Arrays.stream(weights).max().getAsInt();
        int e = 500 * 5 * 10000;
        while(s < e){
            int mid = s + (e - s) / 2;
            if(calc(weights, mid, days)){
                e = mid;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
    boolean calc(int[] weights, int capacity, int target) {

        int days = 1;
        int sum = 0;
        
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > capacity) {
                sum = weights[i];
                days++;
            }
        }
        if (days > target)
            return false;
        return true;
    }
}