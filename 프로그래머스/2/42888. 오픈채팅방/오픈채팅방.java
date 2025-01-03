import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        int cnt = 0;
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String[] s = record[i].split("\\s");
            if(s.length > 2)
                map.put(s[1], s[2]);
            if(s[0].equals("Enter") || s[0].equals("Leave"))
                cnt++;
        }
        answer = new String[cnt];
        cnt = 0;
        for(int i = 0; i < record.length; i++){
            String[] s = record[i].split("\\s");
            String nickname = map.get(s[1]);
            if(s[0].equals("Enter")){
                answer[cnt++] = nickname + "님이 들어왔습니다.";
            }else if(s[0].equals("Leave"))
                answer[cnt++] = nickname + "님이 나갔습니다.";
        }
        return answer;
    }
}