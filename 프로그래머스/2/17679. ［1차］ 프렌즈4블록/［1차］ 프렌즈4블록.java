import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] nboard = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                nboard[i][j] = board[i].charAt(j);
            }
        }
        boolean isBoardFixed = false;
        while(!isBoardFixed){
            List<int[]> point = findBlock(m, n, nboard);
            answer += removeBlock(point, nboard);
            isBoardFixed = moveBlock(nboard);
        }
        return answer;
    }
    
    List<int[]> findBlock(int m, int n, char[][] board){
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < m - 1; i++){
            for(int j = 0;  j < n - 1; j++){
                char a = board[i][j];
                char b = board[i + 1][j];
                char c = board[i][j + 1];
                char d = board[i + 1][j + 1];
                if(a == 0)
                    continue;
                if(a == b && b == c && c == d){
                    list.add(new int[]{i, j});
                    list.add(new int[]{i + 1, j});
                    list.add(new int[]{i, j + 1});
                    list.add(new int[]{i + 1, j + 1});
                }
            }
        }
        return list;
    }
    int removeBlock(List<int[]> point, char[][] board){
        int removeCnt = 0;
        for(int[] p : point){
            char c = board[p[0]][p[1]];
            if(c == 0)
                continue;
            board[p[0]][p[1]] = 0;
            removeCnt++;
        }
        return removeCnt;
    }
    
    boolean moveBlock(char[][] board){
        boolean isBlockNotMoved = true;
        for(int i = 0; i < board[0].length; i++){
            for(int j = board.length - 1; j > 0; j-- ){
                if(board[j][i] == 0){
                    for(int k = 1; j - k >= 0; k++){
                        if(board[j - k][i] != 0){
                            board[j][i] = board[j - k][i];
                            board[j - k][i] = 0;
                            isBlockNotMoved = false;
                            break;
                        }
                    }
                }
            }
        }
        return isBlockNotMoved;
    }
}