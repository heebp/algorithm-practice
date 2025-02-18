class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int lockCnt = 0;
        for(int i = 0; i < lock.length; i++){
            for(int j = 0; j < lock.length; j++){
                if(lock[i][j] == 0)
                    lockCnt++;
            }
        }
        for(int i = -lock.length + 1; i < lock.length; i++){
            for(int j = -lock.length + 1; j < lock.length; j++){
                for(int k = 0; k < 4; k++){
                    if(isFit(i, j, key = rotate(key), lock, lockCnt))
                        return true;
                }
            }
        }
        return false;
    }
    
    int[][] rotate(int[][] key){
        int[][] rotateKey = new int[key.length][key.length];
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                rotateKey[i][j] = key[key.length - 1 - j][i];
            }
        }
        return rotateKey;
    }
    
    boolean isFit(int nx, int ny, int[][] key, int[][] lock, int lockCnt){
        int hit = 0;
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                int x = i + nx;
                int y = j + ny;
                if(x < 0 || y < 0 || x >= lock.length || y >= lock.length)
                    continue;
                if(lock[x][y] == 1 && key[i][j] == 1)
                    return false;
                if(lock[x][y] == 0 && key[i][j] == 1)
                    hit++;
            }
        }
        
        if(hit != lockCnt)
            return false;
        return true;
    }
}