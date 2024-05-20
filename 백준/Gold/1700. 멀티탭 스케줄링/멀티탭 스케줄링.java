import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] multiTap = new int[N];
        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i = 0; i < K; i++){
            if(isExist(arr[i], multiTap))
                continue;
            int idx = emptySpace(multiTap);
            if(idx < multiTap.length){
                multiTap[idx] = arr[i];
                continue;
            }

            idx = findFurthestSchedule(i, multiTap, arr);
            multiTap[idx] = arr[i];
            cnt++;
        }
        System.out.println(cnt);
    }
    static boolean isExist(int cur, int[] multiTap){
        for(int i = 0; i < multiTap.length; i++){
            if(cur == multiTap[i])
                return true;
        }
        return false;
    }
    static int emptySpace(int[] multiTap){
        int idx = 0;
        while(idx < multiTap.length){
            if(multiTap[idx] == 0)
                return idx;
            idx++;
        }
        return idx;
    }

    static int findFurthestSchedule(int cur, int[] multiTap, int[] arr){
        int max = -1;
        int maxIdx = -1;
        for(int i = 0; i < multiTap.length; i++){
            int dist = 0;
            for(int j = cur + 1; j < arr.length; j++){
                if(multiTap[i] == arr[j])
                    break;
                dist++;
            }
            if(dist > max){
                max = dist;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
