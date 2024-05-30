import java.util.*;

class Solution {
    static boolean[][] used;
    static boolean[][] filled;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        void rotate(){
            int tmp = x;
            x = -y;
            y = tmp;
        }
        void move(int a, int b){
            x -= a;
            y -= b;
        }
    }
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        used = new boolean[table.length][table.length];
        filled = new boolean[table.length][table.length];
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table.length; j++){
                if(!used[i][j] && table[i][j] == 1){
                    List<Point> shape = new ArrayList<>();
                    shape.add(new Point(i,j));
                    used[i][j] = true;
                    findShape(shape, table);
                    for(int k = 0; k < 4; k++){
                        for(Point p : shape)
                            p.rotate();
                        int cnt = fillPuzzle(shape, game_board);
                        answer += cnt;
                        if(cnt > 0){
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    void findShape(List<Point> shape,int[][] table){
        Queue<Point> q = new LinkedList<>();
        q.add(shape.get(0));
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < table.length && ny < table.length 
                   && table[nx][ny] == 1 && !used[nx][ny]){
                    used[nx][ny] = true;
                    q.add(new Point(nx,ny));
                    shape.add(new Point(nx,ny));
                }
            }
        }
    }
    
    int fillPuzzle(List<Point> shape, int[][] game_board){
        for(int i = -game_board.length; i < game_board.length * 2; i++){
            for(int j = -game_board.length; j < game_board.length * 2; j++){
                int hit = 0;
                for(Point p : shape){
                    int nx = p.x + i;
                    int ny = p.y + j;
                    if(nx >= 0 && ny >= 0 && nx < game_board.length && ny < game_board.length){
                        if(!filled[nx][ny] && game_board[nx][ny] == 0)
                            hit++;
                        else
                            break;
                    }
                }
                if(hit == shape.size()){
                    for(Point p : shape)
                        filled[p.x + i][p.y + j] = true;
                    if(hasEmptySpace(shape, game_board, i, j)){
                        for(Point p : shape)
                            filled[p.x + i][p.y + j] = false;
                    }else{
                        return shape.size();
                    }
                }
            }
        }
        return 0;
    }
    
    boolean hasEmptySpace(List<Point> shape, int[][] game_board, int i, int j){              
        for(Point p : shape){
            for(int k = 0; k < 4; k++){
                int nx = p.x + i + dx[k];
                int ny = p.y + j + dy[k];
                if(nx >= 0 && ny >= 0 && nx < game_board.length && ny < game_board.length){
                    if(!filled[nx][ny] && game_board[nx][ny] == 0)
                        return true;       
                }
            }
        }
        return false;
    }
}