class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minL = Integer.MAX_VALUE;
        int minU = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxD = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minL = Math.min(minL, j);
                    minU = Math.min(minU, i);
                    maxR = Math.max(maxR, j);
                    maxD = Math.max(maxD, i);
                } 
            }
        }
        answer = new int[]{minU, minL, maxD + 1, maxR + 1};
        return answer;
    }
}