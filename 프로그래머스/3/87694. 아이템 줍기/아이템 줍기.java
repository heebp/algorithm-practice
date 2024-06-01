class Solution {
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        map = new int[52][52];
        createMap(rectangle);
        
        for(int i = 0; i < 4; i++){
            int nx = characterX + dx[i];
            int ny = characterY + dy[i];
            if(map[ny][nx] == 0 || map[ny][nx] > 10 && map[ny][nx] == map[characterY][characterX])
                continue;
            if(map[ny][nx] == -map[characterY][characterX])
                continue;
            answer = Math.min(search(i, characterX, characterY, itemX, itemY), answer);
        }
        return answer;
    }
    int search(int index, int startX, int startY, int endX, int endY){
        int cnt = 1;
        int nx = startX + dx[index];
        int ny = startY + dy[index];
        
        while(true){
            if(nx == endX && ny == endY)
                return cnt;
            int direction = index;
            if(map[ny][nx] > 4){
                for(int i = 0; i < 4; i++){
                    if(i == (index + 2) % 4 || i == index)
                        continue;
                    int ax = nx + dx[i];
                    int by = ny + dy[i];
                    if(map[by][ax] == 0)
                        continue;
                    if(map[ny][nx] > 10 && (map[ny][nx] == map[by][ax]))
                        continue;
                    if(map[ny][nx] < 10 && map[by][ax] < 10 && map[by][ax] > 4 && (map[ny][nx] != map[by][ax]))
                        continue;
                    if(map[ny][nx] < 10 && map[by][ax] < 4 && map[ny][nx] - 4 != Math.abs(map[by][ax]))
                        continue;
                    direction = i;
                }
            }

            nx += dx[direction];
            ny += dy[direction];
            index = direction;            
            cnt++;
        }
    }
    void createMap(int[][] rectangle){
        int index = 1;
        for(int[] rect : rectangle){
            for(int i = rect[1]; i <= rect[3]; i++){
                createSide(i, rect[0], rectangle, index);
                createSide(i, rect[2], rectangle, -index);
            }
            for(int i = rect[0]; i <= rect[2]; i++){
                createSide(rect[1], i, rectangle, index);
                createSide(rect[3], i, rectangle, -index);
            }
            index++;
        }
    }
    void createSide(int x, int y, int[][] rectangle, int rectIndex){
        if(isNotInside(x, y, rectangle, Math.abs(rectIndex))){
            if(map[x][y] == 0){
                map[x][y] = rectIndex;
            }else if(Math.abs(map[x][y]) == Math.abs(rectIndex))
                map[x][y] = Math.abs(map[x][y]) + 4;
            else
                map[x][y] = (Math.abs(map[x][y])) * 10 + Math.abs(rectIndex);
        }
    }
    boolean isNotInside(int x, int y, int[][] rectangle, int target){
        int index = 0;
        for(int[] rect : rectangle){
            index++;
            if(index == target)
                continue;
            if(rect[0] < y && y < rect[2] && rect[1] < x && x < rect[3])
                return false;
        }
        return true;
    }
}