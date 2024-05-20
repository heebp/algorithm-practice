import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> genresPlay = new HashMap<>();
        Map<String, List<Integer[]>> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            genresPlay.put(genres[i], genresPlay.getOrDefault(genres[i], 0) + plays[i]);
            
            List<Integer[]> lists = map.getOrDefault(genres[i], new ArrayList<>());
            lists.add(new Integer[]{plays[i], i});
            map.put(genres[i], lists);
        }
        
        for(String key : map.keySet()){
            List<Integer[]> lists = map.get(key);
            Collections.sort(lists, new Comparator<Integer[]>(){
               
                @Override
                public int compare(Integer[] o1, Integer[] o2){
                    return o2[0] - o1[0];
                }
            });
        }
        
        List<String> orderGenre = new ArrayList<>(genresPlay.keySet());
        Collections.sort(orderGenre, new Comparator<String>(){
           
            @Override
            public int compare(String o1, String o2){
                return genresPlay.get(o2) - genresPlay.get(o1);
            }
        });
        for(String genre : orderGenre){
            List<Integer[]> play = map.get(genre);
            answerList.add(play.get(0)[1]);
            if(play.size() > 1)
                answerList.add(play.get(1)[1]);
        }
        answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}