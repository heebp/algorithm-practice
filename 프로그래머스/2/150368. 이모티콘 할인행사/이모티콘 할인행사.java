import java.util.*;

class Solution {
    static int[] rateMap = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        answer = new int[2];
        backtracking(users, emoticons, new ArrayList<>(), answer);
        return answer;
    }
    
    void backtracking(int[][] users, int[] emo, List<Integer> rate, int[] max){
        if(rate.size() == emo.length){
            int[] res = calc(users, emo, rate);
            if(res[0] > max[0]){
                max[0] = res[0];
                max[1] = res[1];
            }else if(res[0] == max[0] && res[1] > max[1]){
                max[1] = res[1];
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            rate.add(i);
            backtracking(users, emo, rate, max);
            rate.remove(rate.size() - 1);
        }
    }
    
    int[] calc(int[][] users, int[] emo, List<Integer> rate){
        int plusService = 0;
        int profit = 0;
        for(int[] user : users){
            int[] cur = user.clone();
            int savePoint = profit;
            for(int i = 0; i < rate.size(); i++){
                int ratio = rateMap[rate.get(i)];
                if(ratio < cur[0])
                    continue;
                int price = emo[i] - (emo[i] * ratio / 100);
                if(cur[1] - price <= 0){
                    plusService++;
                    profit = savePoint;
                    break;
                }
                cur[1] -= price;
                profit += price;
            }
        }
        return new int[]{plusService, profit};
    }
}