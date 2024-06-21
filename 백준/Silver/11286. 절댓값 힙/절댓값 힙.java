import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                pq.add(Math.abs(num));
                map.put(num, map.getOrDefault(num, 0) + 1);
            }else{
                if(!pq.isEmpty()){
                    int min = pq.poll();
                    if(map.containsKey(-min) && map.get(-min) != 0){
                        bw.write(-min+"\n");
                        map.put(-min, map.get(-min) -1);
                    }else if(map.containsKey(min) && map.get(min) != 0){
                        bw.write(min + "\n");
                        map.put(min, map.get(min) -1);
                    }
                }else{
                    bw.write(0+"\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
