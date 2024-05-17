import java.util.*;

class Solution {
    static class Range implements Comparable<Range>{
        int s;
        int e;
        Range(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Range range){
            return this.e - range.e;
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        List<Range> list = new ArrayList<>();
        for(int[] target : targets)
            list.add(new Range(target[0], target[1]));
        Collections.sort(list);
        int range = 0;
        for(int i = 0; i < list.size(); i++){
            if(range <= list.get(i).s){
                range = list.get(i).e;
                answer++;
            }   
        }
        return answer;
    }
}