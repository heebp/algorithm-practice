import java.util.*;
/*  시간복잡도
    t * m ~= 10만 => O(n) 풀이 가능
*/
class Solution {
    static char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder preNum = new StringBuilder();
        int num = 0;
        while(preNum.length() <= t * m){
            preNum.append(baseConverter(num, n, new StringBuilder()));
            num++;
        }
        StringBuilder res = new StringBuilder();
        int cur = 0;
        p--;
        while(res.length() < t){
            int turn = cur % m;
            if(turn == p){
                res.append(preNum.charAt(cur));
            }
            cur++;
        }
        answer = res.toString();
        return answer;
    }
    
    String baseConverter(int num, int base, StringBuilder sb){
        if(num < base){
            sb.append(DIGITS[num]);
        }else{
            baseConverter(num / base, base, sb);
            sb.append(DIGITS[num % base]);
        }
        return sb.toString();
    }
}