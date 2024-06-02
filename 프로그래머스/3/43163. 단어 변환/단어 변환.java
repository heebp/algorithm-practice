import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        
        answer = bfs(begin, target, words, visited);
        return answer;
    }
    int bfs(String begin, String target, String[] words, boolean[] visited){
        Queue<int[]> q = new LinkedList<>();
        add(begin, words, q, 0);
        while(!q.isEmpty()){
            int[] index = q.poll();
            String word = words[index[0]];
            if(word.equals(target))
                return index[1];
            add(word, words, q, index[1]);
        }
        return 0;
    }
    
    void add(String word, String[] words, Queue<int[]> q, int cnt){
        int length = word.length();
        for(int i = 0; i < words.length; i++){
            if(visited[i])
                continue;
            int hit = 0;
            for(int j = 0; j < length; j++){
                if(word.charAt(j) == words[i].charAt(j))
                    hit++;
            }
            if(length == hit + 1){
                visited[i] = true;
                q.add(new int[]{i, cnt + 1});
            }
        }
    }
}