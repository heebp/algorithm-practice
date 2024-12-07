import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ",-1);
        for(int j = 0; j < words.length; j++){
            String word = words[j];
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(i % 2 == 0)
                    sb.append(Character.toUpperCase(c));
                else
                    sb.append(Character.toLowerCase(c));
            }
            if(j != words.length - 1)
                sb.append(" ");
        }
        answer = sb.toString();
        return answer;
    }
}