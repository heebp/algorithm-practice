import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] lostMap = new boolean[n];
        boolean[] isUsed = new boolean[n];
         for(int l : lost)
            lostMap[l - 1] = true;
        
        for(int num : reserve){
            int i = num - 1;
            
            if(lostMap[i]){
                lostMap[i] = false;
                isUsed[i] = true;
            }
        }
        
        for(int num : reserve){
            int i = num - 1;
            if(isUsed[i])
                continue;
            if(i != 0 && lostMap[i - 1]){
                lostMap[i - 1] = false;
                System.out.println(i);
                continue;
            }
            if(i != lostMap.length - 1 && lostMap[i + 1]){
                lostMap[i + 1] = false;
            }
        }
        
        for(int i = 0; i < lostMap.length; i++){
            if(!lostMap[i])
                answer++;
        }
        return answer;
    }
}