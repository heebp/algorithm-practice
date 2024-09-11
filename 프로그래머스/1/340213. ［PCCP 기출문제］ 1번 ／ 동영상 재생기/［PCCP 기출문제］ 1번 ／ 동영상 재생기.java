class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int s_len = timeToInt(video_len);
        int s_num = timeToInt(op_start);
        int e_num = timeToInt(op_end);
        int cur = timeToInt(pos);
        if(isOpening(cur, s_num, e_num))
            cur = e_num;
        for(String command : commands){
            if("next".equals(command)){
                cur += 10;
                if(cur > s_len)
                    cur = s_len;                    
            }else{
                cur -= 10;
                if(cur < 0)
                    cur = 0;                    
            }
            if(isOpening(cur, s_num, e_num))
                cur = e_num;
        }
        answer = intToTime(cur);
        return answer;
    }
    
    int timeToInt(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }
    
    String intToTime(int time){
        int h = time / 60;
        int m = time % 60;
        String sh = h + "";
        String sm = m + "";
        if(sh.length() == 1)
            sh = "0" + sh;
        if(sm.length() == 1)
            sm = "0" + sm;
        return sh +":"+sm;
    }
    
    boolean isOpening(int cur, int s, int e){
        if(s <= cur && cur <= e)
            return true;
        return false;
    }
}