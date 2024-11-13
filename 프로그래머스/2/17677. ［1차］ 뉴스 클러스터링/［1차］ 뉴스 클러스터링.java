import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> s1 = make(str1);
        List<String> s2 = make(str2);        
        if(s1.size() == 0 && s2.size() == 0)
            return 65536;
        
        int a1 = 0;
        for(int i = 0; i < s1.size(); i++){
            for(int j = 0; j < s2.size(); j++){
                if(s1.get(i).equals(s2.get(j))){
                    a1++;
                    s2.set(j, "");
                    break;
                }
            }
        }
        
        int a2 = s1.size() + s2.size() - a1;
        answer = (int)Math.floor((double)a1 / a2 * 65536);
        return answer;
    }
    boolean isValid(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;        
        return false;
    }
    
    List<String> make(String str){
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < str.length() - 1; i++){
            if(!isValid(str.charAt(i)) || !isValid(str.charAt(i + 1)))
                continue;
            list.add(""+ Character.toLowerCase(str.charAt(i)) + Character.toLowerCase(str.charAt(i + 1)));
        }
        return list;
    }
}