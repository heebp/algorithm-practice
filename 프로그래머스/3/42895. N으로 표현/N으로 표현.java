import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        answer = bfs(N, number);
        return answer;
    }
    
    int bfs(int N, int number){
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Integer[]> q = new PriorityQueue<>(new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        for(int i = 1; i <= 8; i++){
            int n = Integer.parseInt(sb.append(N).toString());
            q.add(new Integer[]{n, i});
        }
        q.add(new Integer[]{N, 1});
        q.add(new Integer[]{-N, 1});
        while(!q.isEmpty()){
            Integer[] n = q.poll();
            if(map.get(n[0]) != null)
                continue;
            else
                map.put(n[0], n[1]);
            if(n[0] == number)
                return n[1];
            if(n[1] == 9)
                return -1;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int cnt = n[1] + entry.getValue();
                if(cnt > 8)
                    continue;
                N = entry.getKey();
                for(int i = 0; i < 4; i++){
                    int num = n[0];
                    if(i == 0)
                        num += N;
                    else if(i == 1)
                        num *= N;
                    else if(i == 2)
                        num -= N;
                    else if(i == 3 && N != 0)
                        num /= N;
                    if(map.get(num) == null || cnt < map.get(num)){
                        q.add(new Integer[]{num, cnt});
                    }
                }
            }
        }
        return -1;
    }
}