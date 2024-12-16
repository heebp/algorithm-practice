class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = countOne(Integer.toBinaryString(n));
        while(true){
            n++;
            if(nCnt == countOne(Integer.toBinaryString(n)))
                break;
        }
        answer = n;
        return answer;
    }
    
    int countOne(String b){
        int cnt = 0;
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }
}