class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length(); i++){
            int top = sb.length() - 1;

            while(top >= 0 && k > 0 && sb.charAt(top) > num.charAt(i)){
                sb.deleteCharAt(top--);
                k--;
            }
            sb.append(num.charAt(i));
        }
        while(k > 0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        int idx = 0;
        while(idx < sb.length() && sb.charAt(idx) == '0'){
            idx++;
        }
        sb.delete(0, idx);
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}