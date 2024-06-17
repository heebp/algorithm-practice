import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N + 3];
        int[] sumArr = new int[N + 3];
        Set<Integer> set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            int idx = Integer.parseInt(st.nextToken());
            if(set.contains(idx))
                continue;
            for(int j = idx; j < arr.length; j += idx){
                if(set.contains(j))
                    continue;
                arr[j] = true;
            }
        }
        
        for(int i = 1; i < sumArr.length; i++){
            sumArr[i] += sumArr[i - 1];
            if(!arr[i])
                sumArr[i] += 1;
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(sumArr[e] - sumArr[s - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}