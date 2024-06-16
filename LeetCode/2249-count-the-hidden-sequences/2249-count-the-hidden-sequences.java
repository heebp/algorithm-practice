class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long s = lower;
        long e = upper;
        long sum = 0;
        for(int diff : differences){
            sum += diff;
            if(sum > 0)
                e = Math.min(e, upper - sum);
            else
                s = Math.max(s, lower - sum);
        }
        return e - s >= 0 ? (int)(e - s + 1): 0;
    }
}