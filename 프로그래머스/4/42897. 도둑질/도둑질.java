// a : 첫집을 털었고, 마지막 집을 안 털었을 경우
// b : 첫집을 안 털었고, 마지막 집을 털었을 경우
// c : 첫집을 안 털었고, 마지막 집을 안 털었을 경우

class Solution {
    public int solution(int[] money) {
        int curr1 = 0, prev1 = 0;
        int curr2 = 0, prev2 = 0;
        
        for (int i = 0; i < money.length-1; i++) {
            int temp1 = curr1;
            curr1 = Math.max(temp1, prev1+money[i]);
            prev1 = temp1;
        }
        
        for (int i = 1; i < money.length; i++) {
            int temp2 = curr2;
            curr2 = Math.max(temp2, prev2+money[i]);
            prev2 = temp2;
        }
        
        return Math.max(curr1, curr2);
    }
}
