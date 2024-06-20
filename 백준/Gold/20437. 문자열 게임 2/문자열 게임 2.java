import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < W.length(); j++) {
                List<Integer> idx = map.getOrDefault(W.charAt(j), new ArrayList<>());
                idx.add(j);
                map.put(W.charAt(j), idx);
            }
            for (List<Integer> list : map.values()) {
                if(list.size() >= K){
                    int s = 0;
                    int e = K - 1;
                    while(e < list.size()){
                        min = Math.min(min, list.get(e) - list.get(s) + 1);
                        max = Math.max(max, list.get(e) - list.get(s) + 1);
                        s++;
                        e++;
                    }
                }
            }
            bw.write(min == Integer.MAX_VALUE ? -1 +" " : min+" ");
            if(min == Integer.MAX_VALUE)
                continue;
            bw.write(max+"\n");
        }
        bw.flush();
        bw.close();
    }
}
