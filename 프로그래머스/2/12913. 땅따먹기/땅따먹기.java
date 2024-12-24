class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                int localMax = 0;
                for(int k = 0; k < land[0].length; k++){
                    if(j == k)
                        continue;
                    localMax = Math.max(localMax, land[i - 1][k]);
                }
                land[i][j] += localMax;
                answer = Math.max(answer, land[i][j]);
            }
        }
        return answer;
    }
}