import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = convertBase(n, k, new StringBuilder());
        String[] pCandidate = num.split("0");
        for(String p : pCandidate){
            if(!"".equals(p) && isP(Long.valueOf(p)))
                answer++;
        }
        return answer;
    }
    
    String convertBase(int num, int base, StringBuilder sb){
        if(num < base){
            sb.append(num);
        }else{
            convertBase(num / base, base, sb);
            sb.append(num % base);
        }
        return sb.toString();
    }
    boolean isP(long num){
        if(num < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}