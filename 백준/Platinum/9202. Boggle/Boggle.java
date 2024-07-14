import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] map;
    static class WordMap{
        Map<Character, List<WordMap>> children = new HashMap<>();
        void insert(int depth, int r, int c, boolean[][] visited) {
            if(depth == 8)
                return;
            visited[r][c] = true;
            List<WordMap> next = children.get(map[r][c]);
            if(next == null){
                next = new ArrayList<>();
                next.add(new WordMap());
                children.put(map[r][c], next);
            }else{
                next.add(new WordMap());
            }
            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(OOD(nr, nc) || visited[nr][nc])
                    continue;
                next.get(next.size() - 1).insert(depth + 1, nr, nc, visited);
            }
            visited[r][c] = false;
        }

        boolean search(int idx, String word) {
            if(idx == word.length())
                return true;
            List<WordMap> list = children.get(word.charAt(idx));
            if(list == null)
                return false;
            for (WordMap wordMap : list) {
                if(wordMap.search(idx + 1, word))
                    return true;
            }
            return false;
        }
        boolean OOD(int i , int j){
            if(i < 0 || j < 0 || i >= map.length || j >= map[0].length)
                return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int w = Integer.parseInt(br.readLine());
        String[] words = new String[w];
        int[] score = {0,0,0,1,1,2,3,5,11};
        for (int i = 0; i < w; i++)
            words[i] = br.readLine();

        br.readLine();
        int a = Integer.parseInt(br.readLine());
        for(int i = 0; i < a; i++){
            if(i != 0)
                br.readLine();

            WordMap root = new WordMap();
            map = new char[4][4];
            for(int j = 0; j < 4; j++){
                String s = br.readLine();
                for (int k = 0; k < s.length(); k++) {
                    map[j][k] = s.charAt(k);
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    boolean[][] visited = new boolean[map.length][map[0].length];
                    root.insert(0, j, k, visited);
                }
            }

            int totalScore = 0;
            String max = "";
            int cnt = 0;
            for (String word : words) {
                if(root.search(0, word)){
                    if(compare(max, word))
                        max = word;
                    cnt++;
                    totalScore += score[word.length()];
                }
            }
            bw.write(totalScore+" "+max+" "+cnt+"\n");
        }
        bw.flush();
        bw.close();
    }
    static boolean compare(String s1, String s2){
        if(s1.length() > s2.length())
            return false;
        if(s1.length() < s2.length())
            return true;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) > s2.charAt(i))
                return true;
            if(s1.charAt(i) < s2.charAt(i))
                return false;
        }
        return false;
    }
}
