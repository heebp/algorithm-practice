import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (int[] o1, int[] o2)->{
            return o1[0] - o2[0];
        });
        int sum = 0;
        int s = arr[0][0];
        int e = arr[0][1];
        for(int i = 0; i < arr.length; i++){
            if(e >= arr[i][0]){
                e = Math.max(e, arr[i][1]);
            }else{
                sum += e - s;
                s = arr[i][0];
                e = arr[i][1];
            }
        }
        sum += e - s;
        System.out.println(sum);
    }
}
