import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class WordTree{
        int cnt;
        int min_idx;
        Map<Character, WordTree> wordMap;
        WordTree(Map<Character, WordTree> wordMap, int idx){
            this.wordMap = wordMap;
            this.min_idx = idx;
        }
        void insert(String s, int i){
            int idx = 0;
            Map<Character, WordTree> cur = this.wordMap;
            this.cnt++;
            this.min_idx = Math.min(min_idx, i);
            while(idx < s.length()){
                char c = s.charAt(idx);
                WordTree next = cur.getOrDefault(c, new WordTree(new HashMap<>(), 20001));
                next.cnt++;
                next.min_idx = Math.min(next.min_idx, i);
                cur.put(c, next);
                cur = next.wordMap;
                idx++;
            }
        }

        int getSimilarWord(String s, int idx, int prev_idx) {
            if(idx == s.length())
                return prev_idx;

            char c = s.charAt(idx);
            WordTree wt = this.wordMap.get(c);
            if (wt.cnt > 1)
                return wt.getSimilarWord(s, idx + 1, wt.min_idx);
            else
                return prev_idx;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        WordTree wt = new WordTree(new HashMap<>(), 20001);
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            wt.insert(arr[i], i);
        }
        int max = -1;
        int max_i = 0;
        int max_j = 1;
        for (int i = 0; i < N; i++) {
            int j = wt.getSimilarWord(arr[i], 0, i);
            if(i == j)
                continue;
            int d = diff(arr[i], arr[j]);
            if(d > max){
                max = d;
                max_i = i;
                max_j = j;
            }else if(d == max){
                if(i < max_i && i < max_j || j < max_i && j < max_j){
                    max_i = i;
                    max_j = j;
                }
            }
        }
        System.out.println(max_i < max_j ? arr[max_i]+"\n"+arr[max_j] : arr[max_j] +"\n"+arr[max_i]);
    }
    public static int diff(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(s2.length() == i || s1.charAt(i) != s2.charAt(i))
                return i;
        }
        return s1.length();
    }
}