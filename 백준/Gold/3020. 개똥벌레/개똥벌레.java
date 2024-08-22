import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] top = new int[N / 2];
        int[] bottom = new int[N / 2];
        for (int i = 0; i < N; i++) {
            if(i % 2 == 0)
                bottom[i / 2] = Integer.parseInt(br.readLine());
            else
                top[i / 2] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(top);
        Arrays.sort(bottom);
        int min = Integer.MAX_VALUE;
        int minCnt = 0;
        for(int i = 1; i <= H; i++){
            int res = binary_search(i, bottom) + binary_search(H - i + 1, top);
            if(min == res){
                minCnt++;
            }else if(min > res){
                min = res;
                minCnt = 1;
            }
        }
        System.out.println(min +" "+ minCnt);
        br.close();
    }
    static int binary_search(int target, int[] arr){
        int l = 0;
        int r = arr.length;
        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return arr.length - r;
    }
}
