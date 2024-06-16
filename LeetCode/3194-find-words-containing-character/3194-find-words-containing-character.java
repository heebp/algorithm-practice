import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(isCharacterExist(words[i], x))
                list.add(i);
        }
        return list;
    }
    boolean isCharacterExist(String word, char x){
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == x)
                return true;
        }
        return false;
    }
}