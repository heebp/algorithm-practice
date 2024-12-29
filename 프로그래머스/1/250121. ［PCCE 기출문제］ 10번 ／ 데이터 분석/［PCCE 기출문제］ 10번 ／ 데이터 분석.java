import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        int sortIdx = ntoi(sort_by);
        int extIdx = ntoi(ext);
        Arrays.sort(data, new Comparator<int[]>(){
           
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[sortIdx], o2[sortIdx]);
            }
        });
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            if(data[i][extIdx] < val_ext)
                list.add(data[i]);
        }
        answer = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    int ntoi(String s){
        if(("code".equals(s)))
            return 0;
        else if("date".equals(s))
            return 1;
        else if("maximum".equals(s))
            return 2;
        else
            return 3;
    }
}