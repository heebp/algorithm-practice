import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) times[times.length - 1] * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long pplInTime = 0;
            for (int i = 0; i < times.length; i++) {
                pplInTime += mid / times[i];
            }
            if (pplInTime < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}