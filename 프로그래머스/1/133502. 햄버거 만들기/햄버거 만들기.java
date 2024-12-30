import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(1000000);
        for(int num : ingredient){
            sb.append(num);
            if(num != 1)
                continue;
            if(!canWrap(sb))
                continue;
            sb.delete(sb.length() - 4, sb.length());
            answer++;
        }
        return answer;
    }
    boolean canWrap(StringBuilder sb){
        if(sb.length() < 4)
            return false;
        int[] order = {1,3,2,1};
        for(int i = 0; i < 4; i++){
            if(order[i] != sb.charAt(sb.length() - 1 - i) - '0')
                return false;
        }
        return true;
    }
}