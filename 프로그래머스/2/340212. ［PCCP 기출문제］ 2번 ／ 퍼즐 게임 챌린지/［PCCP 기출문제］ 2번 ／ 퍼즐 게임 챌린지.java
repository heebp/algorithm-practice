public class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int maxDiff = 0;
        for (int diff : diffs) {
            if (diff > maxDiff) maxDiff = diff;
        }

        int low = 1, high = maxDiff;
        int answer = maxDiff;  // Initialize with the maximum possible level

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(diffs, times, limit, mid)) {
                answer = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] diffs, int[] times, long limit, int level) {
        int n = diffs.length;
        long total_time = times[0];  // Start with the time of the first puzzle

        for (int i = 1; i < n; i++) {
            if (diffs[i] <= level) {
                total_time += times[i];
            } else {
                long mistakes = diffs[i] - level;
                total_time += mistakes * (times[i] + times[i -1]) + times[i];
            }
            if (total_time > limit) {
                return false;  // Early exit if the limit is exceeded
            }
        }
        return total_time <= limit;
    }
}