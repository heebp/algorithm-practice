import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Puzzle{
        Point R;
        Point B;
        boolean[][] Rvisited;
        boolean[][] Bvisited;
        int cnt;
        Puzzle() { }
        Puzzle(Point R, Point B, int cnt, boolean[][] Rvisited, boolean[][] Bvisited) {
            this.R = R;
            this.B = B;
            this.cnt = cnt;
            this.Rvisited = Rvisited;
            this.Bvisited = Bvisited;
        }
    }
    static class Point{
        int x;
        int y;
        boolean isEnd;
        Point(int x, int y, boolean isEnd){
            this.x = x;
            this.y = y;
            this.isEnd = isEnd;
        }
        boolean isNotValid(int[][] maze, boolean[][] visited) {
            if (this.x < 0 || this.x >= maze.length || this.y < 0 || this.y >= maze[0].length)
                return true;
            if (maze[this.x][this.y] == 5)
                return true;
            if (visited[this.x][this.y])
                return true;
            return false;
        }
        boolean moving (int pos, int[][] maze, boolean[][] visited) {
            if (!isEnd) {
                this.x = this.x + dx[pos];
                this.y = this.y + dy[pos];
                if (isNotValid(maze, visited)) {
                    return false;
                }
                visited[this.x][this.y] = true;
            }
            return true;
        }
        boolean isSamePoint(Point oppo){
            return this.x == oppo.x && this.y == oppo.y; 
        }
    }
    static boolean isEnd;

    public int solution(int[][] maze) {
        int answer = 0;
        int n = maze.length;
        int m = maze[0].length;
        Puzzle puzzle = new Puzzle();
        puzzle.Rvisited = new boolean[n][m];
        puzzle.Bvisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maze[i][j] == 1) {
                    puzzle.R = new Point(i, j, false);
                    puzzle.Rvisited[i][j] = true;
                }
                if(maze[i][j] == 2){
                    puzzle.B = new Point(i, j, false);
                    puzzle.Bvisited[i][j] = true;
                }
            }
        }
        puzzle.cnt = 0;
        Queue<Puzzle> queue = new LinkedList<>();
        queue.add(puzzle);
        while (!isEnd) {
            Puzzle newP = queue.poll();
            if (newP == null)
                break;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    boolean[][] newRV = new boolean[n][m];
                    boolean[][] newBV = new boolean[n][m];
                    for (int l = 0; l < n; l++) {
                        newRV[l] = Arrays.copyOf(newP.Rvisited[l], newP.Rvisited[l].length);
                        newBV[l] = Arrays.copyOf(newP.Bvisited[l], newP.Bvisited[l].length);
                    }     
                    Puzzle pmap = new Puzzle(new Point(newP.R.x, newP.R.y, newP.R.isEnd), new Point(newP.B.x, newP.B.y, newP.B.isEnd), newP.cnt+1, newRV, newBV);
                    Point rPrev = new Point(pmap.R.x, pmap.R.y, false);
                    Point bPrev = new Point(pmap.B.x, pmap.B.y, false);
                    if(!pmap.R.moving(j, maze, pmap.Rvisited) ||
                       !pmap.B.moving(k, maze, pmap.Bvisited))
                        continue;
                    if ((rPrev.isSamePoint(pmap.B) && bPrev.isSamePoint(pmap.R)) ||
                        pmap.R.isSamePoint(pmap.B))
                        continue;

                    if(maze[pmap.R.x][pmap.R.y] == 3)
                        pmap.R.isEnd = true;
                    if(maze[pmap.B.x][pmap.B.y] == 4)
                        pmap.B.isEnd = true;
                    if (pmap.B.isEnd && pmap.R.isEnd) {
                        answer = pmap.cnt;
                        isEnd = true;
                        return answer;
                    }
                    queue.add(pmap);
                }
            }
        }
        return answer;
    }
}