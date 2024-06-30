import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int nPlusOne = cards.length + 1;
        Set<Integer> deck = new HashSet<>();
        Set<Integer> discardDeck = new HashSet<>();
        int index = 0;
        for(; index < cards.length / 3; index++)
            deck.add(cards[index]);
        index--;
        int cnt = 0;
        boolean flag = true;
        while(flag){
            cnt++;
            flag = false;
            int cur = index + ((cnt - 1) * 2);
            if(cur == cards.length - 1)
                break;
            discardDeck.add(cards[cur + 1]);
            discardDeck.add(cards[cur + 2]);
            for(int i = 1; i <= cards.length / 2; i++){
                if(deck.contains(i) && deck.contains(cards.length - i + 1)){
                    deck.remove(i); 
                    deck.remove(cards.length - i + 1);
                    flag = true;
                    break;
                }
            }
            if(!flag && coin >= 1){
                for(int i = 1; i <= cards.length; i++){
                    if(deck.contains(i) && discardDeck.contains(cards.length - i + 1)){
                        deck.remove(i);
                        discardDeck.remove(cards.length - i + 1);
                        flag = true;
                        coin--;
                        break;
                    }
                }
            }
            if(!flag && coin >= 2){
                for(int i = 1; i <= cards.length / 2; i++){
                    if(discardDeck.contains(i) && discardDeck.contains(cards.length - i + 1)){
                        discardDeck.remove(i);
                        discardDeck.remove(cards.length - i + 1);
                        flag = true;
                        coin -= 2;
                        break;
                    }
                }
            }
        }
        answer = cnt;
        return answer;
    }
}