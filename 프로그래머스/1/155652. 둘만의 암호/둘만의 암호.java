import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] skipMap = new boolean['z' - 'a' + 1];
        for(int i = 0; i < skip.length(); i++){
            skipMap[skip.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            int cur = 0; 
            while(cur < index){
                c = (c + 1) % 26;
                if(skipMap[c])
                    continue;
                
                cur++;
            }
            sb.append((char)('a' + c));
        }
        answer = sb.toString();
        return answer;
    }
}