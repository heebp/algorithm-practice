import java.util.*;
class Solution {
    int[] DIGITS = {1, 2, 4};
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        convert(n - 1, sb);
        answer = sb.toString();
        return answer;
    }
    void convert(int n, StringBuilder sb){
        if(n < 3){
            sb.append(DIGITS[n]);
        }else{
            n -= 3;
            convert(n / 3, sb);
            sb.append(DIGITS[n % 3]);
        }
    }
}