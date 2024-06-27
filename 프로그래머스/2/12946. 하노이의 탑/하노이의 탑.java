//n = 3 = > 2^3 - 1
//1 -> 3, 1 -> 2, 3 -> 2, 1 -> 3, 2 -> 1, 2 -> 3, 1 -> 3
//n = 4
//1 -> 2, 1 -> 3, 2 -> 3, 1 -> 2, 3 -> 1, 3 -> 2, 1 -> 2, 1 -> 3 ....
//cnt = 2^n - 1
import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = {};
        List<Integer[]> list = new ArrayList<>();
        recur(n, 1, 3, 2, list);
        answer = new int[list.size()][];
        
        for(int i = 0; i < list.size(); i++){
            Integer[] arr = list.get(i);
            int[] ret = new int[arr.length];
            for(int j = 0; j < 2; j++){
                ret[j] = arr[j];
            }
            answer[i] = ret;
        }
        for(Integer[] l : list){
            System.out.println(l[0] +","+l[1]);
        }
        return answer;
    }
    
    void recur(int n, int from, int dest, int by, List<Integer[]> list){
        if(n == 1){
            Integer[] moved = {from, dest};
            list.add(moved);
            return;
        }
        recur(n - 1, from , by, dest, list);
        recur(1, from, dest, by, list);
        recur(n - 1, by, dest, from, list);
    }
}