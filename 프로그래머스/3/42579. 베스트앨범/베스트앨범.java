import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genreMap = new HashMap<>();
        
        for(int i =0; i< genres.length; i++){
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreList, (o1, o2) -> (genreMap.get(o2).compareTo(genreMap.get(o1))));
        
        int temp = 0;
        List<Integer> answerList = new ArrayList<>();
        for(String genre : genreList ){
            int max  = 0;
            int second  = 0;
            int max_i = -1;
            int sec_i = -1;
	        for(int i = 0; i < genres.length; i++){
                if(genre.equals(genres[i]) && plays[i] >= max){
                    second = max;
                    sec_i = max_i;
                    max = plays[i];
                    max_i = i;
                }else if( genre.equals(genres[i]) && second <= plays[i] && plays[i] < max){
                    second = plays[i];
                    sec_i = i;
                }
            }
            if( max == second && max_i > sec_i){
                temp = max_i;
                max_i = sec_i;
                sec_i = temp;
            }
            if(max_i != -1 ){
                answerList.add(max_i);
            }
            if(sec_i != -1){
                answerList.add(sec_i);
            }
            max = 0;
            second = 0;
        }
        answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}