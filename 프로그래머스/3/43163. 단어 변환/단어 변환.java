import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = bfs(begin, target, words, new boolean[words.length]);
        return answer;
    }
    int bfs(String begin, String target, String[] words, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        for(int nextWord : findAllNextWord(begin, words, visited)){
            q.add(new int[]{nextWord, 1});
        }
        while(!q.isEmpty()){
            int[] index = q.poll();
            String word = words[index[0]];
            if(word.equals(target))
                return index[1];
            List<Integer> nextWords = findAllNextWord(word, words, visited);
            for(int nextWord : nextWords){
                q.add(new int[]{nextWord, index[1] + 1});
                visited[nextWord] = true;
            }
        }
        return 0;
    }
    
    List<Integer> findAllNextWord(String word, String[] words, boolean[] visited){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(visited[i])
                continue;
            int hit = 0;
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(j) == words[i].charAt(j))
                    hit++;
            }
            if(word.length() == hit + 1){
                list.add(i);
            }
        }
        return list;
    }
}