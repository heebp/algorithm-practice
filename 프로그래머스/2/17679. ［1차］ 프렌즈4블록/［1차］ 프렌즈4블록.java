import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] cboard = new char[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                cboard[i][j] = board[i].charAt(j);
            }
        }
        
        while(true){
            Set<List<Integer>> deletePos = findFourBlock(cboard);
            answer += deletePos.size();
            for(List<Integer> pos : deletePos)
                cboard[pos.get(0)][pos.get(1)] = '0';
            if(deletePos.isEmpty())
                break;
            moveBoard(cboard);
        }
        return answer;
    }
    Set<List<Integer>> findFourBlock(char[][] cboard){
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < cboard.length - 1; i++){
            for(int j = 0; j < cboard[0].length - 1; j++){
                if(cboard[i][j] != '0' && cboard[i][j] == cboard[i + 1][j] &&
                   cboard[i][j] == cboard[i][j + 1] &&
                   cboard[i][j] == cboard[i + 1][j + 1]){
                    res.add(List.of(i, j));
                    res.add(List.of(i, j + 1));
                    res.add(List.of(i + 1, j));
                    res.add(List.of(i + 1, j + 1));
                }
            }
        }
        return res;
    }
    void moveBoard(char[][] board){
        for(int i = board.length - 1; i > 0; i--){
            boolean flag = false;
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '0')
                    continue;
                for(int k = i - 1; k >= 0; k--){
                    if(board[k][j] != '0'){
                        board[i][j] = board[k][j];
                        board[k][j] = '0';
                        break;
                    }
                }
            }
        }
    }
}