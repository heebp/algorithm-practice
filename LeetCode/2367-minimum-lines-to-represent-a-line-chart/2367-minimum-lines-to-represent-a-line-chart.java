import java.util.*;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int x = 0;
        int y = 0;
        int res = 0;
        for(int i = 1; i < stockPrices.length; i++){
            int dy = (stockPrices[i][1] - stockPrices[i - 1][1]);
            int dx = (stockPrices[i][0] - stockPrices[i - 1][0]);
            int gcd = GCD(dy, dx);
            int curY = dy / gcd;
            int curX = dx / gcd;
            if(x != curX || y != curY){
                res++;
                x = curX;
                y = curY;
            }
        }
        return res;
    }
    int GCD(int x, int y) {
        if (x % y == 0) 
            return y;
        return GCD(y, x%y);
    }
}