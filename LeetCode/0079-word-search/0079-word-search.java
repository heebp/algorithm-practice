class Solution {
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(isExist(1, i, j, board, word, visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    boolean isExist(int cur, int r, int c, char[][] board, String word, boolean[][] visited){
        if(cur == word.length())
            return true;

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(OOD(nr, nc, board) || visited[nr][nc] || word.charAt(cur) != board[nr][nc])
                continue;
            visited[nr][nc] = true;
            if(isExist(cur + 1, nr, nc, board, word, visited))
                return true;
            visited[nr][nc] = false;
        }
        
        return false;
    }

    boolean OOD(int nr, int nc, char[][] board){
        if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length)
            return true;
        return false;
    }
}