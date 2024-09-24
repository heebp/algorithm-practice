public class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        answer = binarySearch(diffs, times, limit);
        return answer;
    }
    
    int binarySearch(int[] diffs, int[] times, long limit){
        int low = 1;
        int high = 0;
        for (int diff : diffs) {
            if (diff > high) 
                high = diff;
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(diffs, times, limit, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        long total_time = times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total_time += times[i];
            } else {
                long mistake = diffs[i] - level;
                total_time += mistake * (times[i] + times[i - 1]) + times[i];
            }
            if (total_time > limit) {
                return false;  
            }
        }
        return true;
    }
}