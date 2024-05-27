import java.util.*;

class Solution {
    public String orderlyQueue(String s, int k) {
        String max;
        if(k == 1){
            max = pollAndOffer(s, k);
        }else{
            max = sortString(s);
        }
        return max;
    }
    static String pollAndOffer(String s, int k){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        int st = 0;
        while(st < s.length()){
            list.add(sb.substring(st, sb.length()).toString());
            sb.append(s.charAt(st));
            st++;
        }

        Collections.sort(list);
        return list.get(0);
    }

    static String sortString(String s){
            char[] c = new char[s.length()];
            for(int i = 0; i < s.length(); i++){
                c[i] = s.charAt(i);
            }

            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();
            for(char ch : c)
                sb.append(ch);
            return sb.toString();
    }
}