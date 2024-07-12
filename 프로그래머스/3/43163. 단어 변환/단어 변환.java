import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = recur(begin, 0, target, words, new HashSet<>());
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    int recur(String word, int cnt, String target, String[] words, Set<String> set){
        if(word.equals(target))
            return cnt;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(set.contains(words[i]))
                continue;
            String next = canConvert(word, words[i]);
            if(next == null)
                continue;
            set.add(next);
            min = Math.min(min, recur(next, cnt + 1, target, words, set));
            set.remove(next);
        }
        return min;
    }
    String canConvert(String cur, String candidate){
        int hit = 0;
        
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == candidate.charAt(i))
                hit++;
        }
        if(cur.length() - 1 == hit)
            return candidate;
        return null;
    }
}