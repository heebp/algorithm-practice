import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(isGoodNum(i, arr))
                cnt += 1;
        }
        System.out.println(cnt);
    }

    static boolean isGoodNum(int cur , int[] arr){
        int s = 0;
        int e = arr.length - 1;
        while(s < e){
            int sum = arr[s] + arr[e];
            if(sum == arr[cur]){
                if(s != cur && e != cur)
                    return true;
                if(arr[s + 1] + arr[e] == sum && s + 1 != cur && s + 1 != e && e != cur)
                    return true;
                if(arr[s] + arr[e-1] == sum && e - 1 != cur && e - 1 != s && s != cur)
                    return true;
                s++;
                e--;
            }

            if(sum > arr[cur])
                e--;
            else if(sum < arr[cur])
                s++;
        }
        return false;
    }
}
