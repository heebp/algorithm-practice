import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       String[] answer = {};
        answer = new String[players.length];
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < players.length; i++)
            rank.put(players[i], i);

        for(String name : callings){
            int i = rank.get(name);
            rank.put(players[i], i - 1);
            rank.put(players[i - 1], rank.get(players[i - 1]) + 1);
            swap(i, players);
        }
        for(int i = 0; i < players.length; i++) {
            answer[i] = players[i];
        }
        return answer;
    }
    void swap(int i, String[] players){
        String tmp = players[i];
        players[i] = players[i -1];
        players[i - 1] = tmp;
    }
}