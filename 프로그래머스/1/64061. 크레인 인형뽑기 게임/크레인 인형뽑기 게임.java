import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves){
            int doll = pickDoll(board, move);
            if(doll == -1)
                continue;
            if(!stack.isEmpty() && stack.peek() == doll){
                stack.pop();
                answer += 2;
            }else
                stack.push(doll);
        }
        return answer;
    }
    int pickDoll(int[][] board, int move){
        for(int i = 0; i < board.length; i++){
            if((board[i][move - 1]) != 0){
                int ret = board[i][move - 1];
                board[i][move - 1]  = 0;
                return ret;
            }
        }
        return -1;
    }
}