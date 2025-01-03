import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split("\\s");
            Integer in = recordMap.get(record[1]);
            if(in == null){
                recordMap.put(record[1], timeToMinute(record[0]));
            }else{
                int out = timeToMinute(record[0]);
                totalMap.put(record[1], totalMap.getOrDefault(record[1], 0) + out - in);
                recordMap.remove(record[1]);
            }
            
        }
        for(String key : recordMap.keySet()){
            Integer in = recordMap.get(key);
            totalMap.put(key, totalMap.getOrDefault(key, 0) + 23 * 60 + 59 - in);            
        }
        
        List<String> carList = new ArrayList<>(totalMap.keySet());
        Collections.sort(carList);
        answer = new int[carList.size()];
        int index = 0;
        for(String num : carList){
            int time = totalMap.get(num);
            
            answer[index] = fees[1];
            if(time > fees[0])
                answer[index] += (Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3]);
            index++;
        }
        
        return answer;
    }
    int timeToMinute(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        return h * 60 + m;
    }
}