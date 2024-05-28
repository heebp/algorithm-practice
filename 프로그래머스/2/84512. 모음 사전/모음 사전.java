import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String words = "AEIOU";
        int idx = 0;
        List<String> dictionary = new ArrayList<>();
        make(dictionary, words, new StringBuilder());
        
        while(idx < dictionary.size()){
            if(dictionary.get(idx).equals(word))
                break;
            idx++;
        }
        answer = idx;
        return answer;
    }
    
    void make(List<String> dictionary, String word, StringBuilder sb){
        dictionary.add(sb.toString());
        if(sb.length() == 5)
            return;
        
        for(int i = 0; i < 5; i++){
            sb.append(word.charAt(i));
            make(dictionary, word, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}